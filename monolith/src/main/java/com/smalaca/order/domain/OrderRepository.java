package com.smalaca.order.domain;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class OrderRepository {
    private final Map<UUID, Order> orders = new HashMap<>();

    void save(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public Collection<Order> findAll() {
        return orders.values();
    }

    public Order findById(UUID orderId) {
        return orders.get(orderId);
    }
}
