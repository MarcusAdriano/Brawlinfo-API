package io.github.marcusadriano.bscomparatorapi;


import io.github.marcusadriano.bscomparatorapi.service.impl.BrawlStarsServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class ProxyBsApiApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        Config serverConfig = Config.getInstance();
        Server server = ServerBuilder.forPort(serverConfig.getServerPort())
                .addService(new BrawlStarsServiceImpl())
                .build();

        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("*** shutting down gRPC server since JVM is shutting down");
            log.info("*** server shut down");
        }));

        log.info("*** server started: " + serverConfig.getServerPort());
        server.awaitTermination();
    }



}
