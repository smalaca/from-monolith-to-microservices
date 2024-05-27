package com.smalaca.productscatalogue.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductsCatalogue {
    private final ProductRepository productRepository;

    ProductsCatalogue(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void markAsBought(List<Long> productsIds) {
        log.info("MONOLITH: " + getClass().getSimpleName());

        if (areAllAvailable(productsIds)) {
            List<Product> products = productRepository.findAll(productsIds);
            products.forEach(Product::buy);
        } else {
            throw new NotAvailableProductsException(productsIds);
        }
    }

    private boolean areAllAvailable(List<Long> products) {
        return productRepository.areAllAvailable(products);
    }
}
