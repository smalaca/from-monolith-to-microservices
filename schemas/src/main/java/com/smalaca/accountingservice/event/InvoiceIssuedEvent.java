package com.smalaca.accountingservice.event;

import com.smalaca.event.id.EventId;

import java.util.List;

public record InvoiceIssuedEvent(EventId eventId, Long invoiceId, String invoiceNumber, Long orderId, Long buyerId, List<Long> products) {
}
