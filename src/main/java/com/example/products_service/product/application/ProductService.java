package com.example.products_service.product.application;

import com.example.products_service.product.dto.ProductDto;
import com.example.products_service.product.domain.Product;
import com.example.products_service.product.persistence.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// Geschäftslogik
@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<ProductDto> findAll() {
        return repo.findAll().stream()
                .map(product -> new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }

    public ProductDto findById(Long id) {
        return repo.findById(id)
                .map(product -> new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public ProductDto create(ProductDto dto) {
        Product product = new Product(dto.name(), dto.description(), dto.price());
        Product saved = repo.save(product);
        return new ProductDto(saved.getId(), saved.getName(), saved.getDescription(), saved.getPrice());
    }
}
