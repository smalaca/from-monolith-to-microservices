package com.smalaca.notificationservice.api.rest;

import com.smalaca.notificationservice.domain.Notification;
import com.smalaca.notificationservice.domain.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@Slf4j
@RequestMapping("notification")
public class NotificationRestController {
    private final NotificationRepository notificationRepository;

    NotificationRestController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping
    public Collection<Notification> findAll() {
        log.info("MICROSERVICE: NOTIFICATION SERVICE: findAll: " + getClass().getSimpleName());
        return notificationRepository.findAll();
    }
}
