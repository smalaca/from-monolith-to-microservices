package com.smalaca.order.api;

import com.smalaca.order.domain.OrderDto;
import com.smalaca.order.domain.OrderRepository;
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
        log.info("MONOLITH: " + getClass().getSimpleName() + ":findAll");
        return orderRepository.findAll();
    }

    @GetMapping("/{orderId}")
    public OrderDto findOne(@PathVariable Long orderId) {
        log.info("MONOLITH: " + getClass().getSimpleName() + ":findOne");
        return orderRepository.findById(orderId);
    }
}
