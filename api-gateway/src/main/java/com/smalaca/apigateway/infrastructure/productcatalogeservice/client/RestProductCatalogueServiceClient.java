package com.smalaca.apigateway.infrastructure.productcatalogeservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RestProductCatalogueServiceClient {
    private final RestClient restClient;

    RestProductCatalogueServiceClient(@Value("${services.products-catalogue-service}") String productsCatalogueServiceUrl) {
        this.restClient = RestClient.create(productsCatalogueServiceUrl);
    }

    public List<ProductDto> findAll() {
        return restClient.get()
                .uri("product")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}
