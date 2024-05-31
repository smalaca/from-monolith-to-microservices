package com.smalaca.apigateway.infrastructure.transportservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RestTransportServiceClient {
    private final RestClient restClient;

    RestTransportServiceClient(@Value("${services.transport-service}") String transportServiceUrl) {
        this.restClient = RestClient.create(transportServiceUrl);
    }

    public List<TransportOrderDto> findAll() {
        return restClient.get()
                .uri("transport-order")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}
