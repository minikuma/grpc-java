package me.minikuma.v1;

import io.grpc.StatusRuntimeException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloClient {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private HelloServiceGrpc.HelloServiceBlockingStub blockingStub;

    public HelloClient(HelloServiceGrpc.HelloServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }

    // 전송을 위한 메서드
    public void sendBlockingStub(String clientName) {
        // 요청 메시지 생성
        HelloRequest request = HelloRequest.newBuilder()
                .setClientName(clientName)
                .build();

        try {
            logger.info("전송 메시지 : [ " + request + " ]");
            HelloResponse response = blockingStub.unaryHello(request);
            logger.info("응답 메시지 : [ " + response + " ]");
        } catch (StatusRuntimeException e) {
            logger.info(Level.SEVERE +  "Unary Hello 서비스 호출 중 실패: " + e.getStatus());
        }
    }
}
