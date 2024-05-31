package com.smalaca.transportservice.domain;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TransportOrderRepository {
    private final Map<Long, TransportOrder> orders = new HashMap<>();

    void save(TransportOrder transportOrder) {
        orders.put(transportOrder.getTransportOrderId(), transportOrder);
    }

    public Collection<TransportOrder> findAll() {
        return orders.values();
    }
}
