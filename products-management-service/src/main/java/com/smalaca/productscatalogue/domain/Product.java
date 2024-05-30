package com.smalaca.productscatalogue.domain;

class Product {
    private final Long productId;
    private final String category;
    private final String name;
    private int amount;

    Product(Long productId, int amount, String category, String name) {
        this.productId = productId;
        this.amount = amount;
        this.category = category;
        this.name = name;
    }

    boolean isAvailable() {
        return amount > 0;
    }

    void buy() {
        amount--;
    }

    ProductDto asDto() {
        return new ProductDto(productId, amount, category, name);
    }
}
