package com.example.productservice.product.api;

import com.example.productservice.product.application.ProductService;
import com.example.productservice.product.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductDto> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto dto) {
        return service.create(dto);
    }
}
