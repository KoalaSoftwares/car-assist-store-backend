package com.una.carassiststorebackend.repositories;

import com.una.carassiststorebackend.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);

    List<Product> findByPrice(BigDecimal price);


    Product findById(long id);
}
