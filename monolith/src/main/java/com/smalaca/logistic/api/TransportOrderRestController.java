package com.smalaca.logistic.api;

import com.smalaca.logistic.domain.TransportOrder;
import com.smalaca.logistic.domain.TransportOrderRepository;
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
        log.info("MONOLITH: " + getClass().getSimpleName() + ":findAll");
        return transportOrderRepository.findAll();
    }
}
