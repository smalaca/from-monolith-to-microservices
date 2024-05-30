package com.smalaca.orderservice.domain;

import com.smalaca.orderservice.event.ProductBoughtEvent;

public interface EventRegistry {
    void publish(ProductBoughtEvent productBought);
}
