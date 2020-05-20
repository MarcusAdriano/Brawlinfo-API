package io.github.marcusadriano.bscomparatorapi.service.impl;

import io.github.marcusadriano.BSPlayerRequest;
import io.github.marcusadriano.BrawlStarsGrpc;
import io.github.marcusadriano.Player;
import io.github.marcusadriano.bscomparatorapi.service.BrawlStarsService;
import io.grpc.stub.StreamObserver;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.protobuf.ProtoConverterFactory;

import java.io.IOException;

public final class BrawlStarsServiceImpl extends BrawlStarsGrpc.BrawlStarsImplBase {

    private final BrawlStarsService bsService;

    public BrawlStarsServiceImpl() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.brawlstars.com")
                .addConverterFactory(ProtoConverterFactory.create())
                .build();
        bsService = retrofit.create(BrawlStarsService.class);
    }

    @Override
    public void getPlayer(BSPlayerRequest request, StreamObserver<Player> responseObserver) {
        super.getPlayer(request, responseObserver);
    }
}
