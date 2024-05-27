package com.smalaca.productscatalogue.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
class ProductRepository {
    private final Map<UUID, Product> products = new HashMap<>();

    ProductRepository() {
        add(new Product(UUID.randomUUID(), 1, "Book", "Domain-Driven Design Distilled"));
        add(new Product(UUID.randomUUID(), 2, "Book", "Implementing Domain-Driven Design"));
        add(new Product(UUID.randomUUID(), 2, "Book", "Learning Domain-Driven Design"));
        add(new Product(UUID.randomUUID(), 13, "Book", "Introducing EventStorming"));
        add(new Product(UUID.randomUUID(), 65, "Shoes", "Sneakers"));
        add(new Product(UUID.randomUUID(), 42, "Shoes", "Sandals"));
        add(new Product(UUID.randomUUID(), 13, "Shoes", "Boots"));
    }

    private void add(Product product) {
        products.put(product.getProductId(), product);
    }

    boolean areAllAvailable(List<UUID> products) {
        boolean allExists = products.stream().allMatch(this.products::containsKey);

        if (allExists) {
            return products.stream().allMatch(productId -> {
                return this.products.get(productId).isAvailable();
            });
        } else {
            return false;
        }
    }

    List<Product> findAll(List<UUID> productsIds) {
        List<Product> found = new ArrayList<>();
        productsIds.forEach(productId -> found.add(products.get(productId)));

        return found;
    }
}
