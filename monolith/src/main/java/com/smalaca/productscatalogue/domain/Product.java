package com.smalaca.productscatalogue.domain;

import java.util.UUID;

class Product {
    private final UUID productId;
    private final String category;
    private final String name;
    private int amount;

    Product(UUID productId, int amount, String category, String name) {
        this.productId = productId;
        this.amount = amount;
        this.category = category;
        this.name = name;
    }

    UUID getProductId() {
        return productId;
    }

    boolean isAvailable() {
        return amount > 0;
    }

    void buy() {
        amount--;
    }
}
