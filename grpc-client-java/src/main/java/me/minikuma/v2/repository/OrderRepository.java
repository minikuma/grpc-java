package me.minikuma.v2.repository;

import me.minikuma.v2.domain.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {
    Order insertOrder(Order order);
}
