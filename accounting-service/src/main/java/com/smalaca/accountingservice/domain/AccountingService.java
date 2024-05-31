package com.smalaca.accountingservice.domain;

import com.smalaca.accountingservice.event.InvoiceIssuedEvent;
import com.smalaca.event.id.EventId;
import com.smalaca.orderservice.event.ProductBoughtEvent;
import org.springframework.stereotype.Service;

@Service
public class AccountingService {
    private final InvoiceRepository invoiceRepository;
    private final EventRegistry eventRegistry;

    AccountingService(InvoiceRepository invoiceRepository, EventRegistry eventRegistry) {
        this.invoiceRepository = invoiceRepository;
        this.eventRegistry = eventRegistry;
    }

    public void createFor(ProductBoughtEvent event) {
        Invoice invoice = Invoice.create(event.orderId(), event.buyerId(), event.products());
        invoiceRepository.save(invoice);
        eventRegistry.publish(anInvoiceIssuedEventFor(event, invoice));
    }

    private InvoiceIssuedEvent anInvoiceIssuedEventFor(ProductBoughtEvent event, Invoice invoice) {
        InvoiceDto dto = invoice.asDto();
        EventId eventId = EventId.nextFor(event.eventId().traceId());
        return new InvoiceIssuedEvent(eventId, dto.invoiceId(), dto.invoiceNumber(), dto.orderId(), dto.buyerId(), dto.products());
    }
}
