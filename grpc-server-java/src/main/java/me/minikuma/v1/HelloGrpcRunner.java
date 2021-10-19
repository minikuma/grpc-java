package me.minikuma.v1;

import io.grpc.BindableService;

import java.io.IOException;

/**
 * gRPC Server Main Starter
 */
public class HelloGrpcRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 54321; // client 쪽과 동일 포트
        BindableService bindableService = new HelloGrpcService();
        HelloGrpcServer server = new HelloGrpcServer(port, bindableService);
        server.start();
        Runtime.getRuntime().addShutdownHook(
                new Thread(server::shutDown)
        );
    }
}
