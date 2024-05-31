package com.smalaca.logistic.domain;

import lombok.Getter;

import java.util.List;
import java.util.random.RandomGenerator;

@Getter
public class TransportOrder {
    private final Long transportOrderId;
    private final Long orderId;
    private final List<Long> products;

    private TransportOrder(Long transportOrderId, Long orderId, List<Long> products) {
        this.transportOrderId = transportOrderId;
        this.orderId = orderId;
        this.products = products;
    }

    static TransportOrder create(Long orderId, List<Long> products) {
        return new TransportOrder(RandomGenerator.getDefault().nextLong(), orderId, products);
    }
}
