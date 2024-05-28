package com.smalaca.accounting.domain;

import java.util.UUID;

class InvoiceNumber {
    private final String invoiceNumber;

    private InvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    static InvoiceNumber createFor(Long buyerId) {
        return new InvoiceNumber(buyerId + "-" + UUID.randomUUID());
    }

    String value() {
        return invoiceNumber;
    }
}
