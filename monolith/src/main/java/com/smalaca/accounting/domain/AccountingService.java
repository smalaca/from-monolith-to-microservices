package com.smalaca.accounting.domain;

import com.smalaca.order.domain.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountingService {
    private final InvoiceRepository invoiceRepository;

    AccountingService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public InvoiceDto createFor(OrderDto dto) {
        log.info("MONOLITH: " + getClass().getSimpleName());
        Invoice invoice = Invoice.create(dto.orderId(), dto.buyerId(), dto.products());
        invoiceRepository.save(invoice);
        return invoice.asDto();
    }
}
