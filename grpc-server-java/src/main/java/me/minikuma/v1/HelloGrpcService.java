package me.minikuma.v1;

import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;

/**
 * gRPC Service (Implementation)
 *  - 데이터 처리 부분
 */
public class HelloGrpcService extends HelloServiceGrpc.HelloServiceImplBase {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void unaryHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        // 요청 확인
        logger.info("Hello gRPC Server 에 유입된 메시지 : " + request.getClientName());

        // 처리 과정 (1초 후 응답 가정)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        // 응답 메시지 생성
        HelloResponse response = HelloResponse.newBuilder()
                .setWelcomeMessage("gRPC")
                .build();

        // 응답 전송
        // 응답 시작
        responseObserver.onNext(response);

        // 1초 대기
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        // 응답 완료
        responseObserver.onCompleted();
    }
}
