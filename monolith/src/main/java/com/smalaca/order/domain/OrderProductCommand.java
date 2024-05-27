package com.smalaca.order.domain;

import java.util.List;
import java.util.UUID;

public record OrderProductCommand(UUID buyerId, List<UUID> products, String street, String postalCode, String city) {
}
