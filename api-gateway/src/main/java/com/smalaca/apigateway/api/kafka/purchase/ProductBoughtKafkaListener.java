package com.smalaca.apigateway.api.kafka.purchase;

import com.smalaca.apigateway.domain.purchase.Purchase;
import com.smalaca.apigateway.domain.purchase.PurchaseRepository;
import com.smalaca.orderservice.event.ProductBoughtEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductBoughtKafkaListener {
    private final PurchaseRepository purchaseRepository;

    ProductBoughtKafkaListener(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @KafkaListener(
            topics = "${kafka.topics.product-bought}",
            groupId = "${kafka.group-id}",
            containerFactory = "productBoughtEventListenerContainerFactory")
    public void listenGroupOneOdd(ProductBoughtEvent event) {
        log.info("MICROSERVICE: API GATEWAY: " + getClass().getSimpleName());
        log.info("Received OrderProductCommand: " + event);
        Purchase purchase = purchaseRepository.findById(event.purchaseId());
        purchase.completed();
    }
}
