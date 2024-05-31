package com.smalaca.notification.domain;

import com.smalaca.accounting.domain.InvoiceDto;
import com.smalaca.order.domain.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.random.RandomGenerator;

@Service
@Slf4j
public class NotificationService {
    private final NotificationRepository notificationRepository;

    NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void notifyBuyer(InvoiceDto invoice) {
        log.info("MONOLITH: " + getClass().getSimpleName());
        Notification notification = Notification.builder()
                .title("Invoice: " + invoice.invoiceNumber())
                .recipientId(invoice.buyerId())
                .content(invoice.toString())
                .build();
        notificationRepository.save(notification);
    }

    public void notifyWarehouse(OrderDto order) {
        log.info("MONOLITH: " + getClass().getSimpleName());
        Notification notification = Notification.builder()
                .title("Order: " + order.orderId())
                .recipientId(randomWarehouseId())
                .content(order.toString())
                .build();
        notificationRepository.save(notification);
    }

    private Long randomWarehouseId() {
        return RandomGenerator.getDefault().nextLong();
    }
}
