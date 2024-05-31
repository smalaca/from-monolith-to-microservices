package com.smalaca.apigateway.infrastructure.notificationservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RestNotificationServiceClient {
    private final RestClient restClient;

    RestNotificationServiceClient(@Value("${services.notification-service}") String notificationServiceUrl) {
        this.restClient = RestClient.create(notificationServiceUrl);
    }

    public List<NotificationDto> findAll() {
        return restClient.get()
                .uri("notification")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}
