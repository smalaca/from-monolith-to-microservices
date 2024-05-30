package com.smalaca.apigateway.domain.purchase;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PurchaseRepository {
    private final Map<Long, Purchase> purchases = new HashMap<>();

    public void save(Purchase purchase) {
        purchases.put(purchase.getPurchaseId(), purchase);
    }

    public Purchase findById(Long purchaseId) {
        return purchases.get(purchaseId);
    }

    public Collection<Purchase> findAll() {
        return purchases.values();
    }
}
