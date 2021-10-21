package me.minikuma.v2.service;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.minikuma.v2.ProductRequest;
import me.minikuma.v2.ProductResponse;
import me.minikuma.v2.ProductServiceGrpc;
import me.minikuma.v2.domain.Product;
import me.minikuma.v2.repository.ProductRepository;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.NoSuchElementException;

@Slf4j
@GrpcService
@RequiredArgsConstructor
public class ProductService extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductRepository productRepository;

    @Override
    public void getProductById(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {

        log.info("상품 아이디 요청: {}", request.getProductId());

        int checkLength = (int)(Math.log10(request.getProductId())+1);

        // 잘못된 입력 값 체크
        if (checkLength < 0) {
            throw new IllegalArgumentException();
        }

        // 저장소 조회
        Product findProduct = productRepository.getProductById(request.getProductId());

        // 상품 정보를 못 찾았을 때
        if (findProduct == null) {
            throw new NoSuchElementException();
        }

        // 응답 만들기
        ProductResponse response = ProductResponse.newBuilder()
                .setId(findProduct.getId())
                .setName(findProduct.getName())
                .setPrice(findProduct.getPrice())
                .setQuantity(findProduct.getQuantity())
                .build();

        log.info("상품 정보 응답: {}", response);

        // 응답 전송
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
