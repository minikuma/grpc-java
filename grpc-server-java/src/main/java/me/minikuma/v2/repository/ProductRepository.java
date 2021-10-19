package me.minikuma.v2.repository;

import me.minikuma.v2.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ProductRepository {
    public Product getProductById(long id) {
        Product product = new Product();
        product.insertData();
        return product.getStore().get(id);
    }
}
