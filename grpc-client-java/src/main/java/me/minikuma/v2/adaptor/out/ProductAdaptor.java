package me.minikuma.v2.adaptor.out;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.v2.ProductRequest;
import me.minikuma.v2.ProductResponse;
import me.minikuma.v2.ProductServiceGrpc;
import me.minikuma.v2.dao.out.ProductResponseDto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductAdaptor {

    private ProductServiceGrpc.ProductServiceBlockingStub blockingStub;

    @GrpcClient("blockingStub")
    public void setBlockingStub(ProductServiceGrpc.ProductServiceBlockingStub blockingStub) {
        this.blockingStub = blockingStub;
    }

    /*
        원격지에서 상품 정보를 받아온다. (입력값: 상품 ID)
     */
    public ProductResponseDto getProductById(long productId) {
        // 원격지로 보낼 요청을 만든다.
        ProductRequest request = ProductRequest.newBuilder()
                .setProductId(productId)
                .build();

        log.info("원격지로 보낼 응답 : {}", request);

        // 원격지로 부터 응답을 받는다.
        ProductResponse findProduct = blockingStub.getProductById(request);

        log.info("원격지로부터 받은 응답 : {}", findProduct);

        return ProductResponseDto.builder()
                .id(findProduct.getId())
                .name(findProduct.getName())
                .price(findProduct.getPrice())
                .quantity(findProduct.getQuantity())
                .build();
    }
}