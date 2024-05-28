package com.smalaca.accounting.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InvoiceRepository {
    private final Map<Long, Invoice> invoices = new HashMap<>();

    void save(Invoice invoice) {
        invoices.put(invoice.asDto().invoiceId(), invoice);
    }
}
