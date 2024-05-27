package com.smalaca.order.domain;

import com.smalaca.productscatalogue.domain.ProductsCatalogue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PurchaseService {
    private final ProductsCatalogue productsCatalogue;
    private final OrderRepository orderRepository;

    PurchaseService(ProductsCatalogue productsCatalogue, OrderRepository orderRepository) {
        this.productsCatalogue = productsCatalogue;
        this.orderRepository = orderRepository;
    }

    public Order purchase(OrderProductCommand command) {
        log.info("MONOLITH: " + getClass().getSimpleName());

        productsCatalogue.markAsBought(command.products());
        Address address = new Address(command.street(), command.postalCode(), command.city());
        Order order = Order.create(command.buyerId(), command.products(), address);
        orderRepository.save(order);

        return order;
    }
}
