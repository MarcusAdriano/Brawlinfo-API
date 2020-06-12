package io.github.marcusadriano.bscomparatorapi.service.impl;

import com.googlecode.protobuf.format.JsonFormat;
import io.github.marcusadriano.BSPlayerRequest;
import io.github.marcusadriano.BrawlStarsGrpc;
import io.github.marcusadriano.Player;
import io.github.marcusadriano.bscomparatorapi.Config;
import io.github.marcusadriano.bscomparatorapi.converter.BSApiConverter;
import io.github.marcusadriano.bscomparatorapi.converter.Json2ProtoPlayerConverter;
import io.github.marcusadriano.bscomparatorapi.service.BrawlStarsService;
import io.grpc.stub.StreamObserver;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@Slf4j
public class BrawlStarsServiceImpl extends BrawlStarsGrpc.BrawlStarsImplBase {

    private final BrawlStarsService bsService;
    private final Config config;
    private final String authHeader;

    public BrawlStarsServiceImpl() {
        config = Config.getInstance();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(config.getBSApiUrl())
                .addConverterFactory(new BSApiConverter())
                .build();

        bsService = retrofit.create(BrawlStarsService.class);
        authHeader = config.getBSApiKey();
    }

    @Override
    public void getPlayer(BSPlayerRequest request, StreamObserver<Player> responseObserver) {
        log.info("Entry getPlayer() --> Request for user: {}", request.getGameTag());
        bsService.player(authHeader, request.getGameTag()).enqueue(new Callback<Player>() {

            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {
                log.info("BS API Code: {}, Headers: {}", response.code(), response.headers().toString());
                if (!response.isSuccessful()) {
                    Player p = Json2ProtoPlayerConverter.INSTANCE.convert(response.errorBody());
                    responseObserver.onNext(p);
                    log.info("Exit getPlayer() <-- Body size: {}", p.getSerializedSize());
                } else {
                    log.info("Exit getPlayer() <-- Body size: {}", response.body().getSerializedSize());
                    responseObserver.onNext(response.body());
                }
                responseObserver.onCompleted();
            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {
                log.error(t.getMessage(), t);
                responseObserver.onError(t);
            }
        });
    }
}
