package com.smalaca.orderservice.infrastructure.eventregistry.kafka;

import com.smalaca.orderservice.domain.EventRegistry;
import com.smalaca.orderservice.event.ProductBoughtEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaEventRegistry implements EventRegistry {
    private final KafkaTemplate<String, ProductBoughtEvent> productBoughtEventKafkaTemplate;
    private final String productBoughtTopicName;

    KafkaEventRegistry(
            KafkaTemplate<String, ProductBoughtEvent> productBoughtEventKafkaTemplate,
            @Value("${kafka.topics.product-bought}") String productBoughtTopicName) {
        this.productBoughtEventKafkaTemplate = productBoughtEventKafkaTemplate;
        this.productBoughtTopicName = productBoughtTopicName;
    }

    @Override
    public void publish(ProductBoughtEvent productBought) {
        log.info("MICROSERVICE: ORDER SERVICE: " + getClass().getSimpleName());
        log.info("Sent ProductBoughtEvent: " + productBought);
        productBoughtEventKafkaTemplate.send(productBoughtTopicName, productBought);
    }
}
