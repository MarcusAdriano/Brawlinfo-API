package io.github.marcusadriano.bscomparatorapi.converter;

import io.github.marcusadriano.Brawler;
import io.github.marcusadriano.Player;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Converter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Json2ProtoPlayerConverter implements Converter<ResponseBody, Player>, ProtoPlayerConverter {

    protected static final Json2ProtoPlayerConverter INSTANCE = new Json2ProtoPlayerConverter();

    Json2ProtoPlayerConverter() {}

    @Override
    public Player convert(ResponseBody responseBody) throws IOException {
        try {
            JSONObject body = new JSONObject(responseBody.string());
            Player player = player(body);

            return Player.newBuilder().build();
        } catch (JSONException e) {
            throw new IOException("Failed to parse JSON", e);
        }
    }

    @Override
    public Player player(JSONObject bsApiResponse) {
        Iterable<Brawler> brawlers = brawlers(bsApiResponse);

        return Player.newBuilder()
                .setTag(bsApiResponse.optString("tag"))
                .setName(bsApiResponse.optString("name"))
                .setNameColor(bsApiResponse.optString("nameColor"))
                .setTrophies(bsApiResponse.optDouble("trophies"))
                .setHighestTrophies(bsApiResponse.optDouble("highestTrophies"))
                .setPowerPlayPoints(bsApiResponse.optDouble("powerPlayPoints"))
                .setHighestPowerPlayPoints(bsApiResponse.optDouble("highestPowerPlayPoints"))
                .setExpLevel(bsApiResponse.optDouble("expLevel"))
                .setExpPoints(bsApiResponse.optDouble("expPoints"))
                .setIsQualifiedFromChampionshipChallenge(bsApiResponse.optBoolean("isQualifiedFromChampionshipChallenge"))
                .setThreeVs3Victories(bsApiResponse.optDouble("3vs3Victories"))
                .setSoloVictories(bsApiResponse.optDouble("soloVictories"))
                .setDuoVictories(bsApiResponse.optDouble("duoVictories"))
                .setBestRoboRumbleTime(bsApiResponse.optDouble("bestRoboRumbleTime"))
                .setBestTimeAsBigBrawler(bsApiResponse.optDouble("bestTimeAsBigBrawler"))
                .addAllBrawlers(brawlers)
            .build();
    }

    @Override
    public List<Brawler.Item> items(JSONArray bsBrawlerStarPowers) {
        return bsBrawlerStarPowers.toList().stream()
                .map((spJsonObject) -> {
                    JSONObject startPowerJson = (JSONObject) spJsonObject;
                    return Brawler.Item.newBuilder()
                            .setId(startPowerJson.optDouble("id"))
                            .setName(startPowerJson.optString("name"))
                            .build();
                }).collect(Collectors.toList());
    }

    @Override
    public Iterable<Brawler> brawlers(JSONObject bsApiResponse) {
        JSONArray jsonArray = bsApiResponse.getJSONArray("brawlers");
        return jsonArray.toList().stream()
                .map((jsonObject) -> {
                    JSONObject brawlerJson = (JSONObject) jsonObject;

                    Iterable<Brawler.Item> starPowers = items(brawlerJson.getJSONArray("starPowers"));
                    Iterable<Brawler.Item> gadgets = items(brawlerJson.getJSONArray("gadgets"));

                    return Brawler.newBuilder()
                        .setId(brawlerJson.optDouble("id"))
                        .setName(brawlerJson.optString("name"))
                        .setPower(brawlerJson.optDouble("power"))
                        .setRank(brawlerJson.optDouble("rank"))
                        .setTrophies(brawlerJson.optDouble("trophies"))
                        .setHighestTrophies(brawlerJson.optDouble("highestTrophies"))
                        .addAllStarPowers(starPowers)
                        .addAllGadgets(gadgets)
                    .build();
                }).collect(Collectors.toList());
    }

    @Override
    public Player.Club club(JSONObject bsApiResponse) {
        return null;
    }

    @Override
    public Player.ApiError error(JSONObject bsApiResponse) {
        return null;
    }
}
