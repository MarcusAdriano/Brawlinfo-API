package io.github.marcusadriano.bscomparatorapi.converter;

import io.github.marcusadriano.Brawler;
import io.github.marcusadriano.Player;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Converter;
import retrofit2.internal.EverythingIsNonNull;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Json2ProtoPlayerConverter implements Converter<ResponseBody, Player>, ProtoPlayerConverter {

    protected static final Json2ProtoPlayerConverter INSTANCE = new Json2ProtoPlayerConverter();
    public static final String ID = "id";
    public static final String TAG = "tag";
    public static final String NAME = "name";
    public static final String NAME_COLOR = "nameColor";
    public static final String TROPHIES = "trophies";
    public static final String HIGHEST_TROPHIES = "highestTrophies";
    public static final String POWER_PLAY_POINTS = "powerPlayPoints";
    public static final String HIGHEST_POWER_PLAY_POINTS = "highestPowerPlayPoints";
    public static final String EXP_LEVEL = "expLevel";
    public static final String EXP_POINTS = "expPoints";
    public static final String IS_QUALIFIED_FROM_CHAMPIONSHIP_CHALLENGE = "isQualifiedFromChampionshipChallenge";
    public static final String VS_3_VICTORIES = "3vs3Victories";
    public static final String SOLO_VICTORIES = "soloVictories";
    public static final String DUO_VICTORIES = "duoVictories";
    public static final String BEST_TIME_AS_BIG_BRAWLER = "bestTimeAsBigBrawler";
    public static final String BRAWLERS = "brawlers";
    public static final String STAR_POWERS = "starPowers";
    public static final String GADGETS = "gadgets";
    public static final String POWER = "power";
    public static final String RANK = "rank";
    public static final String CLUB = "club";

    public static final String REASON = "reason";
    public static final String MESSAGE = "message";
    public static final String TYPE = "type";
    public static final String JSON_PARSE_ERROR = "json.parse.error";

    Json2ProtoPlayerConverter() {}

    @Override
    public Player convert(@EverythingIsNonNull ResponseBody responseBody) {
        try {
            JSONObject body = new JSONObject(responseBody.string());
            return player(body);
        } catch (Exception e) {
            return Player.newBuilder()
                    .setSuccess(false)
                    .setError(error(e, responseBody))
                .build();
        }
    }

    @Override
    public Player player(JSONObject bsApiResponse) {
        if (bsApiResponse.optString(TAG, null) == null) {
            return Player.newBuilder()
                    .setSuccess(false)
                    .setError(error(bsApiResponse))
                    .build();
        }

        Iterable<Brawler> brawlers = brawlers(bsApiResponse);
        Player.Club club = club(bsApiResponse);

        return Player.newBuilder()
                .setTag(bsApiResponse.optString(TAG))
                .setName(bsApiResponse.optString(NAME))
                .setNameColor(bsApiResponse.optString(NAME_COLOR))
                .setTrophies(bsApiResponse.optInt(TROPHIES))
                .setHighestTrophies(bsApiResponse.optInt(HIGHEST_TROPHIES))
                .setPowerPlayPoints(bsApiResponse.optInt(POWER_PLAY_POINTS))
                .setHighestPowerPlayPoints(bsApiResponse.optInt(HIGHEST_POWER_PLAY_POINTS))
                .setExpLevel(bsApiResponse.optInt(EXP_LEVEL))
                .setExpPoints(bsApiResponse.optInt(EXP_POINTS))
                .setIsQualifiedFromChampionshipChallenge(bsApiResponse.optBoolean(IS_QUALIFIED_FROM_CHAMPIONSHIP_CHALLENGE))
                .setThreeVs3Victories(bsApiResponse.optInt(VS_3_VICTORIES))
                .setSoloVictories(bsApiResponse.optInt(SOLO_VICTORIES))
                .setDuoVictories(bsApiResponse.optInt(DUO_VICTORIES))
                .setBestTimeAsBigBrawler(bsApiResponse.optInt(BEST_TIME_AS_BIG_BRAWLER))
                .setClub(club)
                .addAllBrawlers(brawlers)
                .setSuccess(true)
            .build();
    }

    @Override
    public List<Brawler.Item> items(JSONArray bsBrawlerStarPowers) {
        return bsBrawlerStarPowers.toList().stream()
                .map((spJsonObject) -> {
                    JSONObject startPowerJson = new JSONObject((HashMap) spJsonObject);
                    return Brawler.Item.newBuilder()
                            .setId(startPowerJson.optInt(ID))
                            .setName(startPowerJson.optString(NAME))
                            .build();
                }).collect(Collectors.toList());
    }

    @Override
    public Iterable<Brawler> brawlers(JSONObject bsApiResponse) {
        JSONArray jsonArray = bsApiResponse.getJSONArray(BRAWLERS);
        return jsonArray.toList().stream()
                .map((jsonObject) -> {
                    JSONObject brawlerJson = new JSONObject((HashMap) jsonObject);

                    Iterable<Brawler.Item> starPowers = items(brawlerJson.getJSONArray(STAR_POWERS));
                    Iterable<Brawler.Item> gadgets = items(brawlerJson.getJSONArray(GADGETS));

                    return Brawler.newBuilder()
                        .setId(brawlerJson.optInt(ID))
                        .setName(brawlerJson.optString(NAME))
                        .setPower(brawlerJson.optInt(POWER))
                        .setRank(brawlerJson.optInt(RANK))
                        .setTrophies(brawlerJson.optInt(TROPHIES))
                        .setHighestTrophies(brawlerJson.optInt(HIGHEST_TROPHIES))
                        .addAllStarPowers(starPowers)
                        .addAllGadgets(gadgets)
                    .build();
                }).collect(Collectors.toList());
    }

    @Override
    public Player.Club club(JSONObject bsApiResponse) {
        JSONObject club = bsApiResponse.getJSONObject(CLUB);
        return Player.Club.newBuilder()
                .setTag(club.optString(TAG))
                .setName(club.optString(NAME))
            .build();
    }

    @Override
    public Player.ApiError error(JSONObject bsApiResponse) {
        return Player.ApiError.newBuilder()
                .setReason(bsApiResponse.optString(REASON))
                .setMessage(bsApiResponse.optString(MESSAGE))
                .setType(bsApiResponse.optString(TYPE))
            .build();
    }

    @Override
    public Player.ApiError error(Exception ex, ResponseBody responseBody) {
       return Player.ApiError.newBuilder()
               .setMessage(ex.getMessage())
               .setReason(JSON_PARSE_ERROR)
           .build();
    }
}
