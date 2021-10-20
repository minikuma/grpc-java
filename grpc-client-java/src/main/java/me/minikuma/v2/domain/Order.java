package me.minikuma.v2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Order {
    private long id;
    private long memberId;
    private long productId;
    private String productName;
    private int productPrice;
    private int productQuantity;
}
