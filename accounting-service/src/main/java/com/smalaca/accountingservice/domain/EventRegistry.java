package com.smalaca.accountingservice.domain;

import com.smalaca.accountingservice.event.InvoiceIssuedEvent;

public interface EventRegistry {
    void publish(InvoiceIssuedEvent invoiceIssuedEvent);
}
