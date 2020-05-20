package io.github.marcusadriano.bscomparatorapi.service.impl;

import io.github.marcusadriano.BSPlayerRequest;
import io.github.marcusadriano.BrawlStarsGrpc;
import io.github.marcusadriano.Player;
import io.grpc.stub.StreamObserver;

public final class BrawlStarsServiceImpl extends BrawlStarsGrpc.BrawlStarsImplBase {

    @Override
    public void getPlayer(BSPlayerRequest request, StreamObserver<Player> responseObserver) {
        super.getPlayer(request, responseObserver);
    }
}
