package com.smalaca.accountingservice.domain;

import com.smalaca.orderservice.event.ProductBoughtEvent;
import org.springframework.stereotype.Service;

@Service
public class AccountingService {
    private final InvoiceRepository invoiceRepository;

    AccountingService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void createFor(ProductBoughtEvent event) {
        Invoice invoice = Invoice.create(event.orderId(), event.buyerId(), event.products());
        invoiceRepository.save(invoice);
    }
}
