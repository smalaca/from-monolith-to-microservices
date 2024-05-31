package com.smalaca.notification.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.random.RandomGenerator;

@Getter
@Builder
public class Notification {
    private static final RandomGenerator RANDOM_GENERATOR = RandomGenerator.getDefault();

    private final Long notificationId = RANDOM_GENERATOR.nextLong();
    private final String title;
    private final Long recipientId;
    private final String content;
}
