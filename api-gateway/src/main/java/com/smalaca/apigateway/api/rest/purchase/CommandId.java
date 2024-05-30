package com.smalaca.apigateway.api.rest.purchase;

import java.time.LocalDateTime;
import java.util.random.RandomGenerator;

public record CommandId(Long traceId, Long commandId, LocalDateTime creationDateTime) {
    static CommandId create() {
        RandomGenerator random = RandomGenerator.getDefault();
        return new CommandId(random.nextLong(), random.nextLong(), LocalDateTime.now());
    }
}
