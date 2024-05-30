package com.smalaca.orderservice.command;

import com.smalaca.command.id.CommandId;
import com.smalaca.orderservice.event.ProductBoughtEvent;

import java.util.List;

public record PurchaseProductCommand(
        CommandId commandId, Long purchaseId, Long buyerId, List<Long> products, String street, String postalCode, String city) {
    public static PurchaseProductCommand create(Long purchaseId, Long buyerId, List<Long> products, String street, String postalCode, String city) {
        return new PurchaseProductCommand(CommandId.create(), purchaseId, buyerId, products, street, postalCode, city);
    }

    public ProductBoughtEvent asProductBought(Long orderId) {
        return ProductBoughtEvent.create(commandId.traceId(), orderId, purchaseId, buyerId, products, street, postalCode, city);
    }
}
