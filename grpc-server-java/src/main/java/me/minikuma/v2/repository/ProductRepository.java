package me.minikuma.v2.repository;

import me.minikuma.v2.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    public Product getProductById(long id) {
        Product product = new Product();
        product.insertData(); // 초기 데이터 저장
        return product.getStore().get(id);
    }
}
