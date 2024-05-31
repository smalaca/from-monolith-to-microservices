package com.smalaca.notificationservice.api.kafka;

import com.smalaca.notificationservice.domain.NotificationService;
import com.smalaca.orderservice.event.ProductBoughtEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductBoughtKafkaListener {
    private final NotificationService notificationService;

    ProductBoughtKafkaListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(
            topics = "${kafka.topics.product-bought}",
            groupId = "${kafka.group-id}",
            containerFactory = "productBoughtEventListenerContainerFactory")
    public void listen(ProductBoughtEvent event) {
        log.info("MICROSERVICE: NOTIFICATION SERVICE: " + getClass().getSimpleName());
        log.info("Received ProductBoughtEvent: " + event);
        notificationService.notifyWarehouse(event);
    }
}
