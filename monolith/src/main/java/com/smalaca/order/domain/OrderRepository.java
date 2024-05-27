package com.smalaca.order.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
class OrderRepository {
    private final Map<UUID, Order> orders = new HashMap<>();

    void save(Order order) {
        orders.put(order.getOrderId(), order);
    }
}
