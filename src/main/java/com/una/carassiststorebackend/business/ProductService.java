package com.una.carassiststorebackend.business;

import com.una.carassiststorebackend.entities.Order;
import com.una.carassiststorebackend.entities.Product;
import com.una.carassiststorebackend.repositories.ProductRepository;
import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        if (logger.isInfoEnabled()) {
            logger.info("Searching all products");
        }
        Iterable<Product> list = this.productRepository.findAll();

        return IteratorUtils.toList(list.iterator());
    }

    public Product getProductById(Long id) {
        if(logger.isInfoEnabled()){
            logger.info("Searching product with id {}",id);
        }
        Optional<Product> product = this.productRepository.findById(id);
        if(product.isEmpty()){
            throw new RuntimeException("Product with id "+id+" not found");
        }
        return product.get();
    }

    public List<Product> getProductsByName(String name) {
        if(logger.isInfoEnabled()){
            logger.info("Searching products with name {}",name);
        }
        List<Product> list = this.productRepository.findByName(name);

        return  IteratorUtils.toList(list.iterator());
    }

    public List<Product> getProductsByPrice(BigDecimal price) {
        if(logger.isInfoEnabled()){
            logger.info("Searching products with price {}",price);
        }
        List<Product> list = this.productRepository.findByPrice(price);

        return  IteratorUtils.toList(list.iterator());
    }

    public Product saveProduct(Product product) {
        if(logger.isInfoEnabled()){
            logger.info("Saving product with details {}",product.toString());
        }

        return this.productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if(logger.isInfoEnabled()){
            logger.info("Deleting product with id {}",id);
        }

        this.productRepository.deleteById(id);
    }

    public boolean isProductExists(Product product){
        Optional<Product> res = this.productRepository.findById(product.getId());
        return res.isPresent();
    }
}
