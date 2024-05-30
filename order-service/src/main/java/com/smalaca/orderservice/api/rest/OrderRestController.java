package com.smalaca.orderservice.api.rest;

import com.smalaca.orderservice.domain.OrderDto;
import com.smalaca.orderservice.domain.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("order")
public class OrderRestController {
    private final OrderRepository orderRepository;

    public OrderRestController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<OrderDto> findAll() {
        log.info("MICROSERVICE: ORDER SERVICE: findAll: " + getClass().getSimpleName());
        return orderRepository.findAll();
    }

    @GetMapping("/{orderId}")
    public OrderDto findOne(@PathVariable Long orderId) {
        log.info("MICROSERVICE: ORDER SERVICE: findOne: " + getClass().getSimpleName());
        return orderRepository.findById(orderId);
    }
}
