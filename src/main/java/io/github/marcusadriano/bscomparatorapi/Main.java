package io.github.marcusadriano.bscomparatorapi;


import io.github.marcusadriano.bscomparatorapi.service.impl.BrawlStarsServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Config serverConfig = Config.getInstance();
        Server server = ServerBuilder.forPort(serverConfig.getServerPort())
                .addService(new BrawlStarsServiceImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("*** shutting down gRPC server since JVM is shutting down");
            System.out.println("*** server shut down");
        }));

        System.out.println("*** server started :" + serverConfig.getServerPort());
        server.awaitTermination();
    }



}
