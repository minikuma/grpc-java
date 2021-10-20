package me.minikuma.v2.dao.in;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {
    private long orderId;
    private long productId;
    private String productName;
    private int productPrice;
    private int productQuantity;
}
