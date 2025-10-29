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
                .map(product -> new ProductDto(product.getArticleNum(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }

    public ProductDto findByArticleNum(String articleNum) {
        return repo.findByArticleNum(articleNum)
                .map(product -> new ProductDto(product.getArticleNum(), product.getName(), product.getDescription(), product.getPrice()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public ProductDto create(ProductDto dto) {
        if (dto.articleNum() == null || dto.articleNum().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "articleNum is required");
        }
        repo.findByArticleNum(dto.articleNum()).ifPresent(existing -> {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "articleNum already exists");
        });

        Product product = new Product(dto.articleNum(), dto.name(), dto.description(), dto.price());
        Product saved = repo.save(product);
        return new ProductDto(saved.getArticleNum(), saved.getName(), saved.getDescription(), saved.getPrice());
    }
}
