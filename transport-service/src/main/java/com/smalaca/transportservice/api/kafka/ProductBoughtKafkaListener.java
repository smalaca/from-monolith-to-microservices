package com.smalaca.transportservice.api.kafka;

import com.smalaca.orderservice.event.ProductBoughtEvent;
import com.smalaca.transportservice.domain.LogisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductBoughtKafkaListener {
    private final LogisticService logisticService;

    ProductBoughtKafkaListener(LogisticService logisticService) {
        this.logisticService = logisticService;
    }

    @KafkaListener(
            topics = "${kafka.topics.product-bought}",
            groupId = "${kafka.group-id}",
            containerFactory = "productBoughtEventListenerContainerFactory")
    public void listen(ProductBoughtEvent event) {
        log.info("MICROSERVICE: TRANSPORT SERVICE: " + getClass().getSimpleName());
        log.info("Received ProductBoughtEvent: " + event);
        logisticService.orderTransportFor(event);
    }
}
