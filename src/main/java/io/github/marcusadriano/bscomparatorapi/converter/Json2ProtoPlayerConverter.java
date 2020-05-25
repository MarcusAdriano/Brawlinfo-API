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
    public static final String KEY_ID = "id";
    public static final String KEY_TAG = "tag";
    public static final String KEY_NAME = "name";
    public static final String KEY_NAME_COLOR = "nameColor";
    public static final String KEY_TROPHIES = "trophies";
    public static final String KEY_HIGHEST_TROPHIES = "highestTrophies";
    public static final String KEY_POWER_PLAY_POINTS = "powerPlayPoints";
    public static final String KEY_HIGHEST_POWER_PLAY_POINTS = "highestPowerPlayPoints";
    public static final String KEY_EXP_LEVEL = "expLevel";
    public static final String KEY_EXP_POINTS = "expPoints";
    public static final String KEY_IS_QUALIFIED_FROM_CHAMPIONSHIP_CHALLENGE = "isQualifiedFromChampionshipChallenge";
    public static final String KEY_3_VS_3_VICTORIES = "3vs3Victories";
    public static final String KEY_SOLO_VICTORIES = "soloVictories";
    public static final String KEY_DUO_VICTORIES = "duoVictories";
    public static final String KEY_BEST_TIME_AS_BIG_BRAWLER = "bestTimeAsBigBrawler";
    public static final String KEY_BRAWLERS = "brawlers";
    public static final String KEY_STAR_POWERS = "starPowers";
    public static final String KEY_GADGETS = "gadgets";
    public static final String KEY_POWER = "power";
    public static final String KEY_RANK = "rank";
    public static final String KEY_CLUB = "club";

    public static final String KEY_ERROR_REASON = "reason";
    public static final String KEY_ERROR_MESSAGE = "message";
    public static final String KEY_ERROR_TYPE = "type";
    public static final String KEY_ERROR_JSON_PARSE_ERROR = "json.parse.error";

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
        if (bsApiResponse.optString(KEY_TAG, null) == null) {
            return Player.newBuilder()
                    .setSuccess(false)
                    .setError(error(bsApiResponse))
                    .build();
        }

        Iterable<Brawler> brawlers = brawlers(bsApiResponse);
        Player.Club club = club(bsApiResponse);

        return Player.newBuilder()
                .setTag(bsApiResponse.optString(KEY_TAG))
                .setName(bsApiResponse.optString(KEY_NAME))
                .setNameColor(bsApiResponse.optString(KEY_NAME_COLOR))
                .setTrophies(bsApiResponse.optInt(KEY_TROPHIES))
                .setHighestTrophies(bsApiResponse.optInt(KEY_HIGHEST_TROPHIES))
                .setPowerPlayPoints(bsApiResponse.optInt(KEY_POWER_PLAY_POINTS))
                .setHighestPowerPlayPoints(bsApiResponse.optInt(KEY_HIGHEST_POWER_PLAY_POINTS))
                .setExpLevel(bsApiResponse.optInt(KEY_EXP_LEVEL))
                .setExpPoints(bsApiResponse.optInt(KEY_EXP_POINTS))
                .setIsQualifiedFromChampionshipChallenge(bsApiResponse.optBoolean(KEY_IS_QUALIFIED_FROM_CHAMPIONSHIP_CHALLENGE))
                .setThreeVs3Victories(bsApiResponse.optInt(KEY_3_VS_3_VICTORIES))
                .setSoloVictories(bsApiResponse.optInt(KEY_SOLO_VICTORIES))
                .setDuoVictories(bsApiResponse.optInt(KEY_DUO_VICTORIES))
                .setBestTimeAsBigBrawler(bsApiResponse.optInt(KEY_BEST_TIME_AS_BIG_BRAWLER))
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
                            .setId(startPowerJson.optInt(KEY_ID))
                            .setName(startPowerJson.optString(KEY_NAME))
                            .build();
                }).collect(Collectors.toList());
    }

    @Override
    public Iterable<Brawler> brawlers(JSONObject bsApiResponse) {
        JSONArray jsonArray = bsApiResponse.getJSONArray(KEY_BRAWLERS);
        return jsonArray.toList().stream()
                .map((jsonObject) -> {
                    JSONObject brawlerJson = new JSONObject((HashMap) jsonObject);

                    Iterable<Brawler.Item> starPowers = items(brawlerJson.getJSONArray(KEY_STAR_POWERS));
                    Iterable<Brawler.Item> gadgets = items(brawlerJson.getJSONArray(KEY_GADGETS));

                    return Brawler.newBuilder()
                        .setId(brawlerJson.optInt(KEY_ID))
                        .setName(brawlerJson.optString(KEY_NAME))
                        .setPower(brawlerJson.optInt(KEY_POWER))
                        .setRank(brawlerJson.optInt(KEY_RANK))
                        .setTrophies(brawlerJson.optInt(KEY_TROPHIES))
                        .setHighestTrophies(brawlerJson.optInt(KEY_HIGHEST_TROPHIES))
                        .addAllStarPowers(starPowers)
                        .addAllGadgets(gadgets)
                    .build();
                }).collect(Collectors.toList());
    }

    @Override
    public Player.Club club(JSONObject bsApiResponse) {
        JSONObject club = bsApiResponse.getJSONObject(KEY_CLUB);
        return Player.Club.newBuilder()
                .setTag(club.optString(KEY_TAG))
                .setName(club.optString(KEY_NAME))
            .build();
    }

    @Override
    public Player.ApiError error(JSONObject bsApiResponse) {
        return Player.ApiError.newBuilder()
                .setReason(bsApiResponse.optString(KEY_ERROR_REASON))
                .setMessage(bsApiResponse.optString(KEY_ERROR_MESSAGE))
                .setType(bsApiResponse.optString(KEY_ERROR_TYPE))
            .build();
    }

    @Override
    public Player.ApiError error(Exception ex, ResponseBody responseBody) {
       return Player.ApiError.newBuilder()
               .setMessage(ex.getMessage())
               .setReason(KEY_ERROR_JSON_PARSE_ERROR)
           .build();
    }
}
