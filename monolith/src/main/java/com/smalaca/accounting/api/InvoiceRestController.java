package com.smalaca.accounting.api;

import com.smalaca.accounting.domain.InvoiceDto;
import com.smalaca.accounting.domain.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("invoice")
public class InvoiceRestController {
    private final InvoiceRepository invoiceRepository;

    public InvoiceRestController(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping
    public List<InvoiceDto> findAll() {
        log.info("MONOLITH: " + getClass().getSimpleName() + ":findAll");
        return invoiceRepository.findAll();
    }
}
