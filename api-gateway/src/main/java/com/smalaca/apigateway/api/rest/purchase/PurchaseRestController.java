package com.smalaca.apigateway.api.rest.purchase;

import com.smalaca.apigateway.domain.purchase.Purchase;
import com.smalaca.apigateway.domain.purchase.PurchaseRepository;
import com.smalaca.orderservice.command.PurchaseProductCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("purchase")
@Slf4j
public class PurchaseRestController {
    private final KafkaTemplate<String, PurchaseProductCommand> purchaseProductCommandKafkaTemplate;
    private final String purchaseProductCommandTopicName;
    private final PurchaseRepository purchaseRepository;

    public PurchaseRestController(
            KafkaTemplate<String, PurchaseProductCommand> purchaseProductCommandKafkaTemplate,
            @Value("${kafka.topics.purchase-product}") String purchaseProductCommandTopicName,
            PurchaseRepository purchaseRepository) {
        this.purchaseProductCommandKafkaTemplate = purchaseProductCommandKafkaTemplate;
        this.purchaseProductCommandTopicName = purchaseProductCommandTopicName;
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public Long purchase(@RequestBody OrderProductCommand orderProductCommand) {
        log.info("MICROSERVICE: API GATEWAY: " + getClass().getSimpleName());
        log.info("Received OrderProductCommand: " + orderProductCommand);

        Purchase purchase = Purchase.create();
        PurchaseProductCommand command = orderProductCommand.asPurchaseProductCommand(purchase.getPurchaseId());
        purchaseProductCommandKafkaTemplate.send(purchaseProductCommandTopicName, command);
        purchaseRepository.save(purchase);

        log.info("Sent PurchaseProductCommand: " + command);
        return purchase.getPurchaseId();
    }

    @GetMapping("/{purchaseId}")
    public Purchase findOne(@PathVariable Long purchaseId) {
        return purchaseRepository.findById(purchaseId);
    }

    @GetMapping
    public Collection<Purchase> findAll() {
        return purchaseRepository.findAll();
    }
}
