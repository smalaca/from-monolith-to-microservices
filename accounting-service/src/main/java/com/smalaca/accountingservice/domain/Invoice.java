package com.smalaca.accountingservice.domain;

import java.util.List;
import java.util.random.RandomGenerator;

class Invoice {
    private static final RandomGenerator RANDOM_GENERATOR = RandomGenerator.getDefault();
    private final Long invoiceId;
    private final InvoiceNumber invoiceNumber;
    private final Long orderId;
    private final Long buyerId;
    private final List<Long> products;

    private Invoice(Long invoiceId, InvoiceNumber invoiceNumber, Long orderId, Long buyerId, List<Long> products) {
        this.invoiceId = invoiceId;
        this.invoiceNumber = invoiceNumber;
        this.orderId = orderId;
        this.buyerId = buyerId;
        this.products = products;
    }

    static Invoice create(Long orderId, Long buyerId, List<Long> products) {
        return new Invoice(RANDOM_GENERATOR.nextLong(), InvoiceNumber.createFor(buyerId), orderId, buyerId, products);
    }

    InvoiceDto asDto() {
        return new InvoiceDto(invoiceId, invoiceNumber.value(), orderId, buyerId, products);
    }
}
