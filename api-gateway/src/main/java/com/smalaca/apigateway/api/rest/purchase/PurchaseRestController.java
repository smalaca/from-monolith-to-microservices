package com.smalaca.apigateway.api.rest.purchase;

import com.smalaca.orderservice.command.PurchaseProductCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchase")
@Slf4j
public class PurchaseRestController {
//    private final OrderServiceClient orderServiceClient;
    private final KafkaTemplate<String, PurchaseProductCommand> purchaseProductCommandKafkaTemplate;
    private final String purchaseProductCommandTopicName;

    public PurchaseRestController(
            KafkaTemplate<String, PurchaseProductCommand> purchaseProductCommandKafkaTemplate,
            @Value("${kafka.topics.purchase-product}") String purchaseProductCommandTopicName) {
        this.purchaseProductCommandKafkaTemplate = purchaseProductCommandKafkaTemplate;
        this.purchaseProductCommandTopicName = purchaseProductCommandTopicName;
    }

    @PostMapping
    public ResponseEntity<Long> purchase(@RequestBody OrderProductCommand orderProductCommand) {
        log.info("MICROSERVICE: API GATEWAY: " + getClass().getSimpleName());
        System.out.println("Received: " + orderProductCommand);
        PurchaseProductCommand command = orderProductCommand.asPurchaseProductCommand();
        System.out.println("Sent: " + command);
        purchaseProductCommandKafkaTemplate.send(purchaseProductCommandTopicName, command);
//        PurchaseResponse response = orderServiceClient.purchase(orderProductCommand);
//        if (response.isSuccess())
//            return ResponseEntity.ok(response.orderId());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
        return null;
    }

    // method to get status of the operation

    @KafkaListener(
//            topics = "${kafka.topics.product-bought}",
            topics = "${kafka.topics.purchase-product}",
            groupId = "${kafka.group-id}",
            containerFactory = "purchaseProductCommandListenerContainerFactory")
    public void listenGroupOneOdd(PurchaseProductCommand command) {
        System.out.println("Received: " + command);
    }
}
