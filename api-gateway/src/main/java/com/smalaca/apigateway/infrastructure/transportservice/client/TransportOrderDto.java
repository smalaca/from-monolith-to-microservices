package com.smalaca.apigateway.infrastructure.transportservice.client;

import java.util.List;

public record TransportOrderDto(Long transportOrderId, Long orderId, List<Long> products) {

}
