package me.minikuma.v2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private long id;
    private String name;
    private int price;
    private int quantity;

    private final Map<Long, Product> store = new ConcurrentHashMap<>();

    public void insertData() {
        init();
    }

    // 초기 데이터
    private void init() {
        store.put(1L, new Product(1L, "상품1", 1000, 10));
        store.put(2L, new Product(2L, "상품2", 2000, 20));
        store.put(3L, new Product(3L, "상품3", 3000, 30));
    }
}