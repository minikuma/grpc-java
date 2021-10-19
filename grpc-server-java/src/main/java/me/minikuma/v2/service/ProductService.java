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

@Slf4j
@GrpcService
@RequiredArgsConstructor
public class ProductService extends ProductServiceGrpc.ProductServiceImplBase {

    private final ProductRepository productRepository;

    @Override
    public void getProductById(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {

        log.info("상품 아이디 요청: {}", request.getProductId());

        // 저장소 조회
        Product findProduct = productRepository.getProductById(request.getProductId());

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
