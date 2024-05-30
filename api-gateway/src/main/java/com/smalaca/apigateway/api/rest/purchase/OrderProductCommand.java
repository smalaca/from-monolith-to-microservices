package com.smalaca.apigateway.api.rest.purchase;

import com.smalaca.orderservice.command.PurchaseProductCommand;

import java.util.List;

public record OrderProductCommand(Long buyerId, List<Long> products, String street, String postalCode, String city) {
    PurchaseProductCommand asPurchaseProductCommand() {
        return PurchaseProductCommand.create(buyerId, products, street, postalCode, city);
    }
}
