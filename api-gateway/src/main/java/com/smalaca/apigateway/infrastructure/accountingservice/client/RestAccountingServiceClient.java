package com.smalaca.apigateway.infrastructure.accountingservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RestAccountingServiceClient {
    private final RestClient restClient;

    RestAccountingServiceClient(@Value("${services.accounting-service}") String accountingServiceUrl) {
        this.restClient = RestClient.create(accountingServiceUrl);
    }

    public List<InvoiceDto> findAll() {
        return restClient.get()
                .uri("invoice")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}
