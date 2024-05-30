package com.smalaca.accountingservice.api.kafka;

import com.smalaca.accountingservice.domain.AccountingService;
import com.smalaca.orderservice.event.ProductBoughtEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductBoughtKafkaListener {
    private final AccountingService accountingService;

    public ProductBoughtKafkaListener(AccountingService accountingService) {
        this.accountingService = accountingService;
    }

    @KafkaListener(
            topics = "${kafka.topics.product-bought}",
            groupId = "${kafka.group-id}",
            containerFactory = "productBoughtEventListenerContainerFactory")
    public void listen(ProductBoughtEvent event) {
        log.info("MICROSERVICE: ACCOUNTING SERVICE: " + getClass().getSimpleName());
        log.info("Received ProductBoughtEvent: " + event);
        accountingService.createFor(event);
    }
}
