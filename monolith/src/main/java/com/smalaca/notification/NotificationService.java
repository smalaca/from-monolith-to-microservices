package com.smalaca.notification;

import com.smalaca.accounting.domain.InvoiceDto;
import com.smalaca.order.domain.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {
    public void notifyBuyer(InvoiceDto invoice) {
        log.info("MONOLITH: " + getClass().getSimpleName());
        log.info("Notification to Buyer about the invoice: " + invoice);
    }

    public void notifyWarehouse(OrderDto order) {
        log.info("MONOLITH: " + getClass().getSimpleName());
        log.info("Notification to Warehouse about the order: " + order);
    }
}
