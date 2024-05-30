package com.smalaca.apigateway.infrastructure.productcatalogeservice.client;

public record ProductDto(Long productId, int amount, String category, String name) {
}
