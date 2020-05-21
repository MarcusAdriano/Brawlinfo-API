package io.github.marcusadriano.bscomparatorapi.service.impl;

import io.github.marcusadriano.BSErrorAPI;
import io.github.marcusadriano.BSPlayerRequest;
import io.github.marcusadriano.BrawlStarsGrpc;
import io.github.marcusadriano.Player;
import io.github.marcusadriano.bscomparatorapi.Config;
import io.github.marcusadriano.bscomparatorapi.service.BrawlStarsService;
import io.grpc.stub.StreamObserver;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.protobuf.ProtoConverterFactory;

public final class BrawlStarsServiceImpl extends BrawlStarsGrpc.BrawlStarsImplBase {

    private final BrawlStarsService bsService;
    private final Config config;
    private final String authHeader;

    public BrawlStarsServiceImpl() {
        config = Config.getInstance();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(config.getBSApiUrl())
                .addConverterFactory(ProtoConverterFactory.create())
                .build();

        bsService = retrofit.create(BrawlStarsService.class);
        authHeader = config.getBSApiKey();
    }

    @Override
    public void getPlayer(BSPlayerRequest request, StreamObserver<Player> responseObserver) {
        bsService.player(authHeader, request.getGameTag()).enqueue(new Callback<Player>() {

            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {
                if (response.isSuccessful()) {
                    responseObserver.onNext(response.body());
                } else {
                    BSErrorAPI errorAPI = BSErrorAPI.newBuilder()
                            .setHttpCode(response.code())
                            .setBody(response.raw().toString()).build();
                    Player player = Player.newBuilder()
                            .setError(errorAPI).build();
                    responseObserver.onNext(player);
                }
                responseObserver.onCompleted();
            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {
                responseObserver.onError(t);
                responseObserver.onCompleted();
            }
        });
    }
}
