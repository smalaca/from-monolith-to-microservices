package com.smalaca.accountingservice.domain;

import java.util.List;

public record InvoiceDto(Long invoiceId, String invoiceNumber, Long orderId, Long buyerId, List<Long> products) {
}
