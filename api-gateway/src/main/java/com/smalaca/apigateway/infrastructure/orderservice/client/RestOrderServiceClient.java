package com.smalaca.apigateway.infrastructure.orderservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RestOrderServiceClient {
    private final RestClient restClient;

    RestOrderServiceClient(@Value("${services.order-service}") String orderServiceUrl) {
        this.restClient = RestClient.create(orderServiceUrl);
    }

    public List<OrderDto> findAll() {
        return restClient.get()
                .uri("order")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    public OrderDto findOne(Long orderId) {
        return restClient.get()
                .uri("order/" + orderId)
                .retrieve()
                .body(OrderDto.class);
    }
}
