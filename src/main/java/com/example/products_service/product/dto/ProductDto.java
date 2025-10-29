package com.example.products_service.product.dto;

// Datentransfer-Objekt |  Schema für API
public record ProductDto(String articleNum, String name, String description, Double price) {

}
