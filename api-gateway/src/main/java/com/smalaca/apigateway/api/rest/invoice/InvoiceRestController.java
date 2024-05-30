package com.smalaca.apigateway.api.rest.invoice;

import com.smalaca.apigateway.infrastructure.accountingservice.client.InvoiceDto;
import com.smalaca.apigateway.infrastructure.accountingservice.client.RestAccountingServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("invoice")
public class InvoiceRestController {
    private final RestAccountingServiceClient restAccountingServiceClient;

    public InvoiceRestController(RestAccountingServiceClient restAccountingServiceClient) {
        this.restAccountingServiceClient = restAccountingServiceClient;
    }

    @GetMapping
    public List<InvoiceDto> findAll() {
        log.info("MICROSERVICE: API GATEWAY: findAll: " + getClass().getSimpleName());
        return restAccountingServiceClient.findAll();
    }
}
