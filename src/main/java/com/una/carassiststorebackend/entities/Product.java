package com.una.carassiststorebackend.entities;

import java.math.BigDecimal;

public class Product {
    private String id;
    private String name;
    private BigDecimal price;
    private String description;

    public Product() { super(); }
    public Product(String name, BigDecimal price, String description) {
        super();
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
