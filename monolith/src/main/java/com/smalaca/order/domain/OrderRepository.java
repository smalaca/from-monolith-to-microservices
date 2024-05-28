package com.smalaca.order.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Repository
public class OrderRepository {
    private final Map<Long, Order> orders = new HashMap<>();

    void save(Order order) {
        orders.put(order.asDto().orderId(), order);
    }

    public List<OrderDto> findAll() {
        return orders.values().stream()
                .map(Order::asDto)
                .collect(toList());
    }

    public OrderDto findById(Long orderId) {
        return orders.get(orderId).asDto();
    }
}
