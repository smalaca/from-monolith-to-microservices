package com.smalaca.transportservice.api.rest;

import com.smalaca.transportservice.domain.TransportOrder;
import com.smalaca.transportservice.domain.TransportOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@Slf4j
@RequestMapping("transport-order")
public class TransportOrderRestController {
    private final TransportOrderRepository transportOrderRepository;

    TransportOrderRestController(TransportOrderRepository transportOrderRepository) {
        this.transportOrderRepository = transportOrderRepository;
    }

    @GetMapping
    public Collection<TransportOrder> findAll() {
        log.info("MICROSERVICE: TRANSPORT SERVICE: findAll: " + getClass().getSimpleName());
        return transportOrderRepository.findAll();
    }
}
