package com.smalaca.notification.domain;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class NotificationRepository {
    private final Map<Long, Notification> notifications = new HashMap<>();

    void save(Notification notification) {
        notifications.put(notification.getNotificationId(), notification);
    }

    public Collection<Notification> findAll() {
        return notifications.values();
    }
}
