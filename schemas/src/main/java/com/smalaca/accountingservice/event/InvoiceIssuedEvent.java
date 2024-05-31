package com.smalaca.accountingservice.event;

import com.smalaca.event.id.EventId;

import java.util.List;

public record InvoiceIssuedEvent(EventId eventId, Long aLong, String s, Long orderId, Long buyerId, List<Long> products) {
}
