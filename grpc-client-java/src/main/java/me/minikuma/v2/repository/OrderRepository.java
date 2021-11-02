package me.minikuma.v2.repository;

import me.minikuma.v2.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderRepository {
    Order insertOrder(Order order);
}
