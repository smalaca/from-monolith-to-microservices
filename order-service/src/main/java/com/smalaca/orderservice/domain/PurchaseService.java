package com.smalaca.orderservice.domain;

import com.smalaca.orderservice.command.PurchaseProductCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PurchaseService {
    private final OrderRepository orderRepository;
    private final EventRegistry eventRegistry;
    private final ProductsCatalogue productsCatalogue;

    PurchaseService(OrderRepository orderRepository, EventRegistry eventRegistry, ProductsCatalogue productsCatalogue) {
        this.orderRepository = orderRepository;
        this.eventRegistry = eventRegistry;
        this.productsCatalogue = productsCatalogue;
    }

    public void purchase(PurchaseProductCommand command) {
        if (productsCatalogue.markAsBought(new ProductsDto(command.products()))) {
            log.info("MICROSERVICES: ORDER SERVICE: products marked as bought");
            Address address = new Address(command.street(), command.postalCode(), command.city());
            Order order = Order.create(command.buyerId(), command.products(), address);

            eventRegistry.publish(command.asProductBought(order.asDto().orderId()));
            orderRepository.save(order);
        } else {
            log.info("MICROSERVICES: ORDER SERVICE: products not marked as bought");
//            eventRegistry.publish(command.asProductBought(order.asDto().orderId()));
        }
    }
}
