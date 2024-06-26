package com.smalaca.order.domain;

import java.util.List;
import java.util.random.RandomGenerator;

class Order {
    private static final RandomGenerator RANDOM_GENERATOR = RandomGenerator.getDefault();

    private final Long orderId;
    private final Long buyerId;
    private final List<Long> products;
    private final Address address;

    private Order(Long orderId, Long buyerId, List<Long> products, Address address) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.products = products;
        this.address = address;
    }

    static Order create(Long buyerId, List<Long> products, Address address) {
        return new Order(RANDOM_GENERATOR.nextLong(), buyerId, products, address);
    }

    OrderDto asDto() {
        return new OrderDto(orderId, buyerId, products, address.street(), address.postalCode(), address.city());
    }
}
