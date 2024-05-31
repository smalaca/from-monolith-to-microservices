package com.smalaca.logistic.domain;

import com.smalaca.order.domain.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogisticService {
    private final TransportOrderRepository transportOrderRepository;

    LogisticService(TransportOrderRepository transportOrderRepository) {
        this.transportOrderRepository = transportOrderRepository;
    }

    public void orderTransportFor(OrderDto order) {
        log.info("MONOLITH: " + getClass().getSimpleName());
        TransportOrder transportOrder = TransportOrder.create(order.orderId(), order.products());
        transportOrderRepository.save(transportOrder);
    }
}
