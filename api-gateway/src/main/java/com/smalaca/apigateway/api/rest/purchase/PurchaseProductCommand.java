package com.smalaca.apigateway.api.rest.purchase;

import java.util.List;

public record PurchaseProductCommand(
        CommandId commandId, Long buyerId, List<Long> products, String street, String postalCode, String city) {
    static PurchaseProductCommand create(Long buyerId, List<Long> products, String street, String postalCode, String city) {
        return new PurchaseProductCommand(CommandId.create(), buyerId, products, street, postalCode, city);
    }
}
