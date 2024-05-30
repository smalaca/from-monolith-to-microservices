package com.smalaca.apigateway.infrastructure.orderservice.client;

import java.util.List;

public record OrderDto(Long orderId, Long buyerId, List<Long> products, String street, String postalCode, String city) {
}
