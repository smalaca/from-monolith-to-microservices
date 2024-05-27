package com.smalaca.productscatalogue.domain;

import java.util.List;
import java.util.UUID;

public class NotAvailableProductsException extends RuntimeException {
    private final List<UUID> products;

    NotAvailableProductsException(List<UUID> products) {
        this.products = products;
    }
}
