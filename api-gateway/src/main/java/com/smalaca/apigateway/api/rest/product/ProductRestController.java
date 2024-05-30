package com.smalaca.apigateway.api.rest.product;

import com.smalaca.apigateway.infrastructure.productcatalogeservice.client.ProductDto;
import com.smalaca.apigateway.infrastructure.productcatalogeservice.client.RestProductCatalogueServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("product")
public class ProductRestController {
    private final RestProductCatalogueServiceClient productCatalogueServiceClient;

    public ProductRestController(RestProductCatalogueServiceClient productCatalogueServiceClient) {
        this.productCatalogueServiceClient = productCatalogueServiceClient;
    }

    @GetMapping
    public List<ProductDto> findAll() {
        log.info("MICROSERVICE: API GATEWAY: findAll: " + getClass().getSimpleName());
        return productCatalogueServiceClient.findAll();
    }
}
