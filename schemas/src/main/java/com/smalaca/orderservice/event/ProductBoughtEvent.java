package com.smalaca.orderservice.event;

import com.smalaca.event.id.EventId;

import java.util.List;

public record ProductBoughtEvent(
        EventId eventId, Long orderId, Long buyerId, List<Long> products, String street, String postalCode, String city) {
    public static ProductBoughtEvent create(
            Long traceId, Long orderId, Long buyerId, List<Long> products, String street, String postalCode, String city) {
        return new ProductBoughtEvent(EventId.nextFor(traceId), orderId, buyerId, products, street, postalCode, city);
    }
}
