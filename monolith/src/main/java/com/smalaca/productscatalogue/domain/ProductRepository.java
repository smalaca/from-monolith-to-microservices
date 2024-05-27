package com.smalaca.productscatalogue.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public
class ProductRepository {
    private final Map<Long, Product> products = new HashMap<>();

    ProductRepository() {
        add(new Product(1L, 1, "Book", "Domain-Driven Design Distilled"));
        add(new Product(2L, 2, "Book", "Implementing Domain-Driven Design"));
        add(new Product(3L, 2, "Book", "Learning Domain-Driven Design"));
        add(new Product(4L, 13, "Book", "Introducing EventStorming"));
        add(new Product(5L, 65, "Shoes", "Sneakers"));
        add(new Product(6L, 42, "Shoes", "Sandals"));
        add(new Product(7L, 13, "Shoes", "Boots"));
    }

    private void add(Product product) {
        products.put(product.getProductId(), product);
    }

    boolean areAllAvailable(List<Long> products) {
        boolean allExists = products.stream().allMatch(this.products::containsKey);

        if (allExists) {
            return products.stream().allMatch(productId -> {
                return this.products.get(productId).isAvailable();
            });
        } else {
            return false;
        }
    }

    List<Product> findAll(List<Long> productsIds) {
        List<Product> found = new ArrayList<>();
        productsIds.forEach(productId -> found.add(products.get(productId)));

        return found;
    }

    public Collection<Product> findAll() {
        return products.values();
    }
}
