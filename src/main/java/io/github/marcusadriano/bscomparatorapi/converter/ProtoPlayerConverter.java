package io.github.marcusadriano.bscomparatorapi.converter;

import io.github.marcusadriano.Brawler;
import io.github.marcusadriano.Player;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface ProtoPlayerConverter {
    Player player(JSONObject bsApiResponse);
    Iterable<Brawler> brawlers(JSONObject bsApiResponse);
    Iterable<Brawler.Item> items(JSONArray array);
    Player.Club club(JSONObject bsApiResponse);
    Player.ApiError error(JSONObject bsApiResponse);
    Player.ApiError error(Exception e, ResponseBody responseBody);
}
