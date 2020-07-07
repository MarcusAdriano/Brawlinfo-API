package io.github.marcusadriano.brawlinfo;

import io.github.marcusadriano.brawlinfo.interceptors.LogInterceptor;
import io.github.marcusadriano.brawlinfo.service.BrawlinfoGrpcService;
import io.grpc.*;
import io.grpc.protobuf.services.ProtoReflectionService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class ProxyBsApiApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        Config serverConfig = Config.getInstance();
        Server server = ServerBuilder.forPort(serverConfig.getServerPort())
                .addService(new BrawlinfoGrpcService())
                //.addService(ProtoReflectionService.newInstance())
                .intercept(new LogInterceptor())
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
