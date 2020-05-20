package io.github.marcusadriano.bscomparatorapi.service;

import io.github.marcusadriano.Player;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface BrawlStarsService {

    @GET("v1/players/{user}")
    Call<Player> player(@Header("Authorization") String authorization, @Path("user") String user);
}
