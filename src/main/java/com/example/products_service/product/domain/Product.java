package com.example.products_service.product.domain;

import jakarta.persistence.*;

// Datenbank-Objekt
@Entity
@Table(name = "products")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String articleNum;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Double price;

    public Product() {}

    public Product(String name, String description, Double price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String articleNum, String name, String description, Double price){
        this.articleNum = articleNum;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    // Getter & Setter
    public Long getId() { return id; }
    public String getArticleNum() { return articleNum; }
    public void setArticleNum(String articleNum) { this.articleNum = articleNum; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}