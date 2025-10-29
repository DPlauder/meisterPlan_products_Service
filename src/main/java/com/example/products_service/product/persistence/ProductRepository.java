package com.example.products_service.product.persistence;

import com.example.products_service.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Daten-Repository | CRUD-Operationen
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByArticleNum(String articleNum);

}
