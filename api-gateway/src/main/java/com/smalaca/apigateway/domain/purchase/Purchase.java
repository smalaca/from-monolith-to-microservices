package com.smalaca.apigateway.domain.purchase;

import lombok.Getter;

import java.util.random.RandomGenerator;

@Getter
public class Purchase {
    private static final RandomGenerator RANDOM_GENERATOR = RandomGenerator.getDefault();

    private final Long purchaseId;
    private PurchaseStatus status;

    private Purchase(Long purchaseId, PurchaseStatus status) {
        this.purchaseId = purchaseId;
        this.status = status;
    }

    public static Purchase create() {
        return new Purchase(RANDOM_GENERATOR.nextLong(), PurchaseStatus.IN_PROGRESS);
    }

    public void completed() {
        status = PurchaseStatus.COMPLETED;
    }
}
