package com.smalaca.orderservice.api.kafka;

import com.smalaca.orderservice.command.PurchaseProductCommand;
import com.smalaca.orderservice.domain.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PurchaseKafkaListener {
    private final PurchaseService purchaseService;

    PurchaseKafkaListener(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @KafkaListener(
            topics = "${kafka.topics.purchase-product}",
            groupId = "${kafka.group-id}",
            containerFactory = "purchaseProductCommandListenerContainerFactory")
    public void listenGroupOneOdd(PurchaseProductCommand command) {
        log.info("MICROSERVICE: ORDER SERVICE: " + getClass().getSimpleName());
        System.out.println("Received PurchaseProductCommand: " + command);
        purchaseService.purchase(command);
    }
}
