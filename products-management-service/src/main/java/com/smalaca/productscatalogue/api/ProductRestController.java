package com.smalaca.productscatalogue.api;

import com.smalaca.productscatalogue.domain.NotAvailableProductsException;
import com.smalaca.productscatalogue.domain.ProductDto;
import com.smalaca.productscatalogue.domain.ProductRepository;
import com.smalaca.productscatalogue.domain.ProductsCatalogue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("product")
public class ProductRestController {
    private final ProductRepository productRepository;
    private final ProductsCatalogue productsCatalogue;

    public ProductRestController(ProductRepository productRepository, ProductsCatalogue productsCatalogue) {
        this.productRepository = productRepository;
        this.productsCatalogue = productsCatalogue;
    }

    @PutMapping
    public boolean markAsBought(@RequestBody ProductsDto dto) {
        log.info("MICROSERVICE: PRODUCTS MANAGEMENT: markAsBought: " + getClass().getSimpleName());

        try {
            productsCatalogue.markAsBought(dto.productsIds());
            return true;
        } catch (NotAvailableProductsException exception) {
            return false;
        }
    }

    @GetMapping
    public List<ProductDto> findAll() {
        log.info("MICROSERVICE: API GATEWAY: findAll: " + getClass().getSimpleName());
        return productRepository.findAll();
    }
}
