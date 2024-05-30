package com.smalaca.orderservice.infrastructure.productcatalogeservice.client;

import com.smalaca.orderservice.domain.ProductsCatalogue;
import com.smalaca.orderservice.domain.ProductsDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class RestProductCatalogueServiceClient implements ProductsCatalogue {
    private final RestClient restClient;

    RestProductCatalogueServiceClient(@Value("${services.products-catalogue-service}") String productsCatalogueServiceUrl) {
        this.restClient = RestClient.create(productsCatalogueServiceUrl);
    }

    @Override
    public Boolean markAsBought(ProductsDto dto) {
        return restClient.put()
                .uri("product")
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto)
                .retrieve()
                .body(Boolean.class);
    }
}
