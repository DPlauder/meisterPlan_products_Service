package com.example.products_service.product.persistence;

import com.example.products_service.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Daten-Repository | CRUD-Operationen
public interface ProductRepository extends JpaRepository<Product, Long> {

}
