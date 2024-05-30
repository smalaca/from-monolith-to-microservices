package com.smalaca.orderservice.infrastructure.eventregistry.kafka;

import com.smalaca.orderservice.domain.EventRegistry;
import com.smalaca.orderservice.event.ProductBoughtEvent;
import com.smalaca.orderservice.event.ProductNotBoughtEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaEventRegistry implements EventRegistry {
    private final KafkaTemplate<String, ProductBoughtEvent> productBoughtEventKafkaTemplate;
    private final KafkaTemplate<String, ProductNotBoughtEvent> productNotBoughtEventKafkaTemplate;
    private final String productBoughtTopicName;
    private final String productNotBoughtTopicName;

    KafkaEventRegistry(
            KafkaTemplate<String, ProductBoughtEvent> productBoughtEventKafkaTemplate,
            KafkaTemplate<String, ProductNotBoughtEvent> productNotBoughtEventKafkaTemplate,
            @Value("${kafka.topics.product-bought}") String productBoughtTopicName,
            @Value("${kafka.topics.product-not-bought}") String productNotBoughtTopicName) {
        this.productBoughtEventKafkaTemplate = productBoughtEventKafkaTemplate;
        this.productNotBoughtEventKafkaTemplate = productNotBoughtEventKafkaTemplate;
        this.productBoughtTopicName = productBoughtTopicName;
        this.productNotBoughtTopicName = productNotBoughtTopicName;
    }

    @Override
    public void publish(ProductBoughtEvent productBought) {
        log.info("MICROSERVICE: ORDER SERVICE: " + getClass().getSimpleName());
        log.info("Sent ProductBoughtEvent: " + productBought);
        productBoughtEventKafkaTemplate.send(productBoughtTopicName, productBought);
    }

    @Override
    public void publish(ProductNotBoughtEvent productNotBought) {
        log.info("MICROSERVICE: ORDER SERVICE: " + getClass().getSimpleName());
        log.info("Sent ProductNotBoughtEvent: " + productNotBought);
        productNotBoughtEventKafkaTemplate.send(productNotBoughtTopicName, productNotBought);
    }
}
