package com.smalaca.order.domain;

import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID orderId;
    private final UUID buyerId;
    private final List<UUID> products;
    private final Address address;

    private Order(UUID orderId, UUID buyerId, List<UUID> products, Address address) {
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.products = products;
        this.address = address;
    }

    static Order create(UUID buyerId, List<UUID> products, Address address) {
        return new Order(UUID.randomUUID(), buyerId, products, address);
    }

    public UUID getOrderId() {
        return orderId;
    }

    public OrderDto asDto() {
        return new OrderDto(orderId, buyerId, products, address.street(), address.postalCode(), address.city());
    }
}
