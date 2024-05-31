package com.smalaca.notification.api;

import com.smalaca.notification.domain.Notification;
import com.smalaca.notification.domain.NotificationRepository;
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
        log.info("MONOLITH: " + getClass().getSimpleName() + ":findAll");
        return notificationRepository.findAll();
    }
}
