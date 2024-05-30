package com.smalaca.event.id;

import java.time.LocalDateTime;
import java.util.random.RandomGenerator;

public record EventId(Long traceId, Long eventId, LocalDateTime creationDateTime) {
    public static EventId nextFor(Long traceId) {
        RandomGenerator random = RandomGenerator.getDefault();
        return new EventId(traceId, random.nextLong(), LocalDateTime.now());
    }
}
