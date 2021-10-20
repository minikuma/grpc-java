package me.minikuma.v2.dao.out;

import lombok.Builder;
import lombok.Data;

/**
 * 원격지 (상품) 정보 응답을 위한 객체
 */
@Data
@Builder
public class ProductResponseDto {
    private long id;
    private String name;
    private int price;
    private int quantity;
}
