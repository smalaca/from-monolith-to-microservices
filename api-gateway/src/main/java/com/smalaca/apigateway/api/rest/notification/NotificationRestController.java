package com.smalaca.apigateway.api.rest.notification;

import com.smalaca.apigateway.infrastructure.notificationservice.client.NotificationDto;
import com.smalaca.apigateway.infrastructure.notificationservice.client.RestNotificationServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("notification")
public class NotificationRestController {
    private final RestNotificationServiceClient restNotificationServiceClient;

    public NotificationRestController(RestNotificationServiceClient restNotificationServiceClient) {
        this.restNotificationServiceClient = restNotificationServiceClient;
    }

    @GetMapping
    public List<NotificationDto> findAll() {
        log.info("MICROSERVICE: API GATEWAY: findAll: " + getClass().getSimpleName());
        return restNotificationServiceClient.findAll();
    }
}
