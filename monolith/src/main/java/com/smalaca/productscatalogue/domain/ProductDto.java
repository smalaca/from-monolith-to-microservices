package com.smalaca.productscatalogue.domain;

import java.util.UUID;

public record ProductDto(UUID productId, int amount, String category, String name) {
}
