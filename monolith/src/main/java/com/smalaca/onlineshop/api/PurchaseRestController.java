package com.smalaca.onlineshop.api;

import com.smalaca.accounting.domain.AccountingService;
import com.smalaca.accounting.domain.InvoiceDto;
import com.smalaca.logistic.LogisticService;
import com.smalaca.notification.NotificationService;
import com.smalaca.order.domain.OrderDto;
import com.smalaca.order.domain.OrderProductCommand;
import com.smalaca.order.domain.PurchaseService;
import com.smalaca.productscatalogue.domain.NotAvailableProductsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("purchase")
@Slf4j
public class PurchaseRestController {
    private final PurchaseService purchaseService;
    private final AccountingService accountingService;
    private final NotificationService notificationService;
    private final LogisticService logisticService;

    PurchaseRestController(
            PurchaseService purchaseService, AccountingService accountingService,
            NotificationService notificationService, LogisticService logisticService) {
        this.purchaseService = purchaseService;
        this.accountingService = accountingService;
        this.notificationService = notificationService;
        this.logisticService = logisticService;
    }

    @PostMapping
    public ResponseEntity<Long> purchase(@RequestBody OrderProductCommand command) {
        log.info("MONOLITH: " + getClass().getSimpleName());
        try {
            OrderDto order = purchaseService.purchase(command);
            InvoiceDto invoice = accountingService.createFor(order);
            notificationService.notifyBuyer(invoice);
            notificationService.notifyWarehouse(order);
            logisticService.orderTransportFor(order);
            return ResponseEntity.ok(order.orderId());
        } catch (NotAvailableProductsException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
