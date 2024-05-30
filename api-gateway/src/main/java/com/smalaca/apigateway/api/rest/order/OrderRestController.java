package com.smalaca.apigateway.api.rest.order;

import com.smalaca.apigateway.infrastructure.orderservice.client.OrderDto;
import com.smalaca.apigateway.infrastructure.orderservice.client.RestOrderServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("order")
public class OrderRestController {
    private final RestOrderServiceClient restOrderServiceClient;

    OrderRestController(RestOrderServiceClient restOrderServiceClient) {
        this.restOrderServiceClient = restOrderServiceClient;
    }

    @GetMapping
    public List<OrderDto> findAll() {
        log.info("MICROSERVICE: API GATEWAY: findAll: " + getClass().getSimpleName());
        return restOrderServiceClient.findAll();
    }

    @GetMapping("/{orderId}")
    public OrderDto findOne(@PathVariable Long orderId) {
        log.info("MICROSERVICE: API GATEWAY: findOne: " + getClass().getSimpleName());
        return restOrderServiceClient.findOne(orderId);
    }
}
