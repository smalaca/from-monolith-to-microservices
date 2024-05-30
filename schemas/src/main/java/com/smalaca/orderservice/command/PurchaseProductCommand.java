package com.smalaca.orderservice.command;

import com.smalaca.command.id.CommandId;

import java.util.List;

public record PurchaseProductCommand(
        CommandId commandId, Long buyerId, List<Long> products, String street, String postalCode, String city) {
    public static PurchaseProductCommand create(Long buyerId, List<Long> products, String street, String postalCode, String city) {
        return new PurchaseProductCommand(CommandId.create(), buyerId, products, street, postalCode, city);
    }
}
