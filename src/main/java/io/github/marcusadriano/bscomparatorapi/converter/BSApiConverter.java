package io.github.marcusadriano.bscomparatorapi.converter;

import io.github.marcusadriano.Player;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Converter;
import retrofit2.Retrofit;

import javax.annotation.Nullable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class BSApiConverter extends Converter.Factory {

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return Json2ProtoConverter.INSTANCE;
    }

    final static class Json2ProtoConverter implements Converter<ResponseBody, Player> {
        protected static final Json2ProtoConverter INSTANCE = new Json2ProtoConverter();

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
}
