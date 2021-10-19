package me.minikuma.v1;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Create gRPC Server
 */
public class HelloGrpcServer {
    // log
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    // address
    private final Server server;
    // port
    private final int port;

    public HelloGrpcServer(int port, BindableService bindableService) {
        this.port = port;
        this.server = ServerBuilder.forPort(this.port)
                .addService(bindableService)
                .build();
    }

    // server start
    public void start() throws IOException, InterruptedException {
        server.start();
        logger.info("Hello gRPC Server Start.... Listening Port : " + this.port);
        server.awaitTermination();
    }

    // server shutdown
    public void shutDown() {
        logger.info("Hello gRPC Server 종료 중...");
        server.shutdown();
        System.err.println("Hello gRPC Server 종료 완료");
    }
}
