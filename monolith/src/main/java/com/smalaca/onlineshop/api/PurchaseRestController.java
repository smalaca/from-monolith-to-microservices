package com.smalaca.onlineshop.api;

import com.smalaca.order.domain.Order;
import com.smalaca.order.domain.OrderProductCommand;
import com.smalaca.order.domain.PurchaseService;
import com.smalaca.productscatalogue.domain.NotAvailableProductsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("purchase")
@Slf4j
public class PurchaseRestController {
    private final PurchaseService purchaseService;

    PurchaseRestController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<UUID> purchase(@RequestBody OrderProductCommand command) {
        log.info("MONOLITH: " + getClass().getSimpleName());
        try {
            Order order = purchaseService.purchase(command);
            return ResponseEntity.ok(order.getOrderId());
        } catch (NotAvailableProductsException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
