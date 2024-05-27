package com.smalaca.productscatalogue.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ProductsCatalogue {
    private final ProductRepository productRepository;

    ProductsCatalogue(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void markAsBought(List<UUID> productsIds) {
        log.info("MONOLITH: " + getClass().getSimpleName());

        if (areAllAvailable(productsIds)) {
            List<Product> products = productRepository.findAll(productsIds);
            products.forEach(Product::buy);
        } else {
            throw new NotAvailableProductsException(productsIds);
        }
    }

    private boolean areAllAvailable(List<UUID> products) {
        return productRepository.areAllAvailable(products);
    }
}
