package com.smalaca.logistic.domain;

import com.smalaca.order.domain.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogisticService {
    public void orderTransportFor(OrderDto order) {
        log.info("MONOLITH: " + getClass().getSimpleName());
        log.info("Transport ordered for the: " + order);
    }
}
