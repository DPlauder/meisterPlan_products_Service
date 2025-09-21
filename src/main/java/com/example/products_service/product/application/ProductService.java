package com.example.productservice.product.application;

import com.example.productservice.product.dto.ProductDto;
import com.example.productservice.product.domain.Product;
import com.example.productservice.product.persistence.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<ProductDto> findAll() {
        return repo.findAll().stream()
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getPrice()))
                .toList();
    }

    public ProductDto findById(Long id) {
        return repo.findById(id)
                .map(p -> new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getPrice()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public ProductDto create(ProductDto dto) {
        Product p = new Product(dto.name(), dto.description(), dto.price());
        Product saved = repo.save(p);
        return new ProductDto(saved.getId(), saved.getName(), saved.getDescription(), saved.getPrice());
    }
}
