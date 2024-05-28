package com.smalaca.productscatalogue.api;

import com.smalaca.productscatalogue.domain.ProductDto;
import com.smalaca.productscatalogue.domain.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("product")
public class ProductRestController {
    private final ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductDto> findAll() {
        log.info("MONOLITH: " + getClass().getSimpleName() + ":findAll");
        return productRepository.findAll();
    }
}
