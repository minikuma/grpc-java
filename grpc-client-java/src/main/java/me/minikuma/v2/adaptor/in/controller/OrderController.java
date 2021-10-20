package me.minikuma.v2.adaptor.in.controller;

import lombok.RequiredArgsConstructor;
import me.minikuma.v2.dao.in.OrderRequest;
import me.minikuma.v2.dao.in.OrderResponse;
import me.minikuma.v2.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<?> order(@RequestBody OrderRequest request) {
        Map<String, OrderResponse> map = new HashMap<>();
        OrderResponse insertOrder = orderService.insertOrder(request);
        map.put("result", insertOrder);
        return ResponseEntity.ok(map);
    }
}
