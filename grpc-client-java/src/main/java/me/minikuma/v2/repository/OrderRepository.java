package me.minikuma.v2.repository;

import lombok.extern.slf4j.Slf4j;
import me.minikuma.v2.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class OrderRepository {

    private static Map<String, Order> store = new ConcurrentHashMap<>();

    /**
     *
     * 주문 정보를 저장한다.
     */
    public Order insertOrder(Order order) {
        store.put("result", order);
        log.info("저장된 주문 정보 : {}", store.entrySet());
        return order;
    }
}
