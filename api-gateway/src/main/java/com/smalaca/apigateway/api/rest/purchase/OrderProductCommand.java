package com.smalaca.apigateway.api.rest.purchase;

import com.smalaca.orderservice.command.PurchaseProductCommand;

import java.util.List;

public record OrderProductCommand(Long buyerId, List<Long> products, String street, String postalCode, String city) {
    PurchaseProductCommand asPurchaseProductCommand(Long purchaseId) {
        return PurchaseProductCommand.create(purchaseId, buyerId, products, street, postalCode, city);
    }
}
