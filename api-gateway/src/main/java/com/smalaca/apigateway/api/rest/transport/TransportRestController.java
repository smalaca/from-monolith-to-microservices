package com.smalaca.apigateway.api.rest.transport;

import com.smalaca.apigateway.infrastructure.transportservice.client.RestTransportServiceClient;
import com.smalaca.apigateway.infrastructure.transportservice.client.TransportOrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("transport-order")
public class TransportRestController {
    private final RestTransportServiceClient restTransportServiceClient;

    public TransportRestController(RestTransportServiceClient restTransportServiceClient) {
        this.restTransportServiceClient = restTransportServiceClient;
    }

    @GetMapping
    public List<TransportOrderDto> findAll() {
        log.info("MICROSERVICE: API GATEWAY: findAll: " + getClass().getSimpleName());
        return restTransportServiceClient.findAll();
    }
}
