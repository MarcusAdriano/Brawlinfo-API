package io.github.marcusadriano.bscomparatorapi.converter;

import com.google.common.annotations.VisibleForTesting;
import io.github.marcusadriano.Player;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Converter;

import java.io.IOException;

public class Json2ProtoPlayerConverter implements Converter<ResponseBody, Player> {

    protected static final Json2ProtoPlayerConverter INSTANCE = new Json2ProtoPlayerConverter();

    Json2ProtoPlayerConverter() {}

    @Override
    public Player convert(ResponseBody responseBody) throws IOException {
        try {
            JSONObject body = new JSONObject(responseBody.string());

            return Player.newBuilder().build();
        } catch (JSONException e) {
            throw new IOException("Failed to parse JSON", e);
        }
    }

}
