package com.smalaca.accounting.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Repository
public class InvoiceRepository {
    private final Map<Long, Invoice> invoices = new HashMap<>();

    void save(Invoice invoice) {
        invoices.put(invoice.asDto().invoiceId(), invoice);
    }

    public List<InvoiceDto> findAll() {
        return invoices.values().stream()
                .map(Invoice::asDto)
                .collect(toList());
    }
}
