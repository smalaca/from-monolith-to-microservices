package com.smalaca.notificationservice.domain;

import com.smalaca.orderservice.event.ProductBoughtEvent;
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

//    public void notifyBuyer(InvoiceDto invoice) {
//        log.info("MICROSERVICE: NOTIFICATION SERVICE: " + getClass().getSimpleName());
//        Notification notification = Notification.builder()
//                .title("Invoice: " + invoice.invoiceNumber())
//                .recipientId(invoice.buyerId())
//                .content(invoice.toString())
//                .build();
//        notificationRepository.save(notification);
//    }

    public void notifyWarehouse(ProductBoughtEvent productBoughtEvent) {
        log.info("MICROSERVICE: NOTIFICATION SERVICE: " + getClass().getSimpleName());
        Notification notification = Notification.builder()
                .title("Order: " + productBoughtEvent.orderId())
                .recipientId(randomWarehouseId())
                .content(productBoughtEvent.toString())
                .build();
        notificationRepository.save(notification);
    }

    private Long randomWarehouseId() {
        return RandomGenerator.getDefault().nextLong();
    }
}
