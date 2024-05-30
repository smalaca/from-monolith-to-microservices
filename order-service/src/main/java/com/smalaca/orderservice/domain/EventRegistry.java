package com.smalaca.orderservice.domain;

import com.smalaca.orderservice.event.ProductBoughtEvent;
import com.smalaca.orderservice.event.ProductNotBoughtEvent;

public interface EventRegistry {
    void publish(ProductBoughtEvent productBought);

    void publish(ProductNotBoughtEvent productNotBought);
}
