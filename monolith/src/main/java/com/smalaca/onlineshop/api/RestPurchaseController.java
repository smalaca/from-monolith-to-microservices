package com.smalaca.onlineshop.api;

import com.smalaca.order.domain.Order;
import com.smalaca.order.domain.OrderProductCommand;
import com.smalaca.order.domain.PurchaseService;
import com.smalaca.productscatalogue.domain.NotAvailableProductsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("purchase")
@Slf4j
public class RestPurchaseController {
    private final PurchaseService purchaseService;

    RestPurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }


    public ResponseEntity<UUID> purchase(OrderProductCommand command) {
        log.info("MONOLITH: " + getClass().getSimpleName());
        try {
            Order order = purchaseService.purchase(command);
            return ResponseEntity.ok(order.getOrderId());
        } catch (NotAvailableProductsException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
