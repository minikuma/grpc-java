package me.minikuma.v1;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class HelloClientStubFactory {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    // stub 생성을 위한 팩토리
    // 채널
    private final ManagedChannel channel;
    // stub 정의 (서버쪽에 구현체가 존재)
    private final HelloServiceGrpc.HelloServiceBlockingStub blockingStub;

    public HelloClientStubFactory(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.blockingStub = HelloServiceGrpc.newBlockingStub(this.channel);
    }

    // 채널 shutdown
    public void shutdownChannel() throws InterruptedException {
        logger.info("gRPC Channel ShutDown...");
        channel.shutdown();
        channel.awaitTermination(3000, TimeUnit.SECONDS);
    }
    // 생성된 stub 을 사용할 수 있게 get method 제공
    public HelloServiceGrpc.HelloServiceBlockingStub getBlockingStub() {
        return blockingStub;
    }
}
