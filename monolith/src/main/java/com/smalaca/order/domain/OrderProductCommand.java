package com.smalaca.order.domain;

import java.util.List;

public record OrderProductCommand(Long buyerId, List<Long> products, String street, String postalCode, String city) {
}
