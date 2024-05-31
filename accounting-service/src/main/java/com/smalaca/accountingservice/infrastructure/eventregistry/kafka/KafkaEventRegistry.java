package com.smalaca.accountingservice.infrastructure.eventregistry.kafka;

import com.smalaca.accountingservice.domain.EventRegistry;
import com.smalaca.accountingservice.event.InvoiceIssuedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaEventRegistry implements EventRegistry {
    private final KafkaTemplate<String, InvoiceIssuedEvent> invoiceIssuedEventKafkaTemplate;
    private final String invoiceIssuedTopicName;

    KafkaEventRegistry(
            KafkaTemplate<String, InvoiceIssuedEvent> invoiceIssuedEventKafkaTemplate,
            @Value("${kafka.topics.invoice-issued}") String invoiceIssuedTopicName) {
        this.invoiceIssuedEventKafkaTemplate = invoiceIssuedEventKafkaTemplate;
        this.invoiceIssuedTopicName = invoiceIssuedTopicName;
    }

    @Override
    public void publish(InvoiceIssuedEvent issuedEvent) {
        log.info("MICROSERVICE: ACCOUNTING SERVICE: " + getClass().getSimpleName());
        log.info("Sent InvoiceIssuedEvent: " + issuedEvent);
        invoiceIssuedEventKafkaTemplate.send(invoiceIssuedTopicName, issuedEvent);
    }
}
