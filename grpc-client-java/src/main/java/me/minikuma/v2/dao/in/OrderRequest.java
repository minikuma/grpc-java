package me.minikuma.v2.dao.in;

import lombok.Data;

@Data
public class OrderRequest {
    private long productId;
    private String productName;
    private int quantity;
}
