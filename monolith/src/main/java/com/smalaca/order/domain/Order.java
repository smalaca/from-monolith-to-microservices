package com.smalaca.order.domain;

import java.util.List;
import java.util.random.RandomGenerator;

public class Order {
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
        return new Order(RandomGenerator.getDefault().nextLong(), buyerId, products, address);
    }

    public Long getOrderId() {
        return orderId;
    }

    public OrderDto asDto() {
        return new OrderDto(orderId, buyerId, products, address.street(), address.postalCode(), address.city());
    }
}
