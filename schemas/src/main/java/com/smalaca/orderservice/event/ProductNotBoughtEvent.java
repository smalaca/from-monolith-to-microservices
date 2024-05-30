package com.smalaca.orderservice.event;

import com.smalaca.event.id.EventId;

public record ProductNotBoughtEvent(EventId eventId, Long purchaseId) {
    public static ProductNotBoughtEvent create(Long traceId, Long purchaseId) {
        return new ProductNotBoughtEvent(EventId.nextFor(traceId), purchaseId);
    }
}
