package me.minikuma.v2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.minikuma.v2.adaptor.out.ProductAdaptor;
import me.minikuma.v2.dao.in.OrderRequest;
import me.minikuma.v2.dao.in.OrderResponse;
import me.minikuma.v2.dao.out.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductAdaptor productAdaptor;

    public OrderResponse insertOrder(OrderRequest request) {
        AtomicInteger orderId = new AtomicInteger(0);

        // 상품 정보 필요
        ProductResponseDto productById = productAdaptor.getProductById(request.getProductId());

        // 주문 만들기

        return OrderResponse.builder()
                .orderId(orderId.incrementAndGet())
                .productId(productById.getId())
                .productName(productById.getName())
                .productPrice(productById.getPrice() * request.getQuantity())
                .productQuantity(request.getQuantity())
                .build();
    }
}
