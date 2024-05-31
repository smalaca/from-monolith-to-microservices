package com.smalaca.apigateway.infrastructure.notificationservice.client;

public record NotificationDto(Long notificationId, String title, Long recipientId, String content) {

}
