package com.smalaca.orderservice.domain;

import com.smalaca.orderservice.command.PurchaseProductCommand;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
//    private final ProductsCatalogue productsCatalogue;
    private final OrderRepository orderRepository;
    private final EventRegistry eventRegistry;

    PurchaseService(OrderRepository orderRepository, EventRegistry eventRegistry) {
//    PurchaseService(ProductsCatalogue productsCatalogue, OrderRepository orderRepository) {
//        this.productsCatalogue = productsCatalogue;
        this.orderRepository = orderRepository;
        this.eventRegistry = eventRegistry;
    }

    public void purchase(PurchaseProductCommand command) {
//        productsCatalogue.markAsBought(command.products());
        Address address = new Address(command.street(), command.postalCode(), command.city());
        Order order = Order.create(command.buyerId(), command.products(), address);

        eventRegistry.publish(command.asProductBought(order.asDto().orderId()));
        orderRepository.save(order);
    }
}
