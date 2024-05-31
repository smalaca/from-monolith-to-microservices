package com.smalaca.transportservice.domain;

import com.smalaca.orderservice.event.ProductBoughtEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogisticService {
    private final TransportOrderRepository transportOrderRepository;

    LogisticService(TransportOrderRepository transportOrderRepository) {
        this.transportOrderRepository = transportOrderRepository;
    }

    public void orderTransportFor(ProductBoughtEvent order) {
        log.info("MICROSERVICE: TRANSPORT SERVICE: " + getClass().getSimpleName());
        TransportOrder transportOrder = TransportOrder.create(order.orderId(), order.products());
        transportOrderRepository.save(transportOrder);
    }
}
