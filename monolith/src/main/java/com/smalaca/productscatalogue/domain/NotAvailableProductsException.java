package com.smalaca.productscatalogue.domain;

import java.util.List;

public class NotAvailableProductsException extends RuntimeException {
    private final List<Long> products;

    NotAvailableProductsException(List<Long> products) {
        this.products = products;
    }
}
