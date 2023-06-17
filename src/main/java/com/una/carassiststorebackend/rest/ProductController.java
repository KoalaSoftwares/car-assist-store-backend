package com.una.carassiststorebackend.rest;

import com.una.carassiststorebackend.business.ProductService;
import com.una.carassiststorebackend.entities.Order;
import com.una.carassiststorebackend.entities.Product;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "")
    public List<Product> getProducts() {
        return this.productService.getProducts();
    }

    @GetMapping(value = "{id}")
    public Product getProductById(@PathVariable Long id) throws Exception {
        if(!ObjectUtils.isEmpty(id)){
            return this.productService.getProductById(id);
        }
        throw new Exception("Product with id "+id+" not found");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product createProduct(@RequestBody @NotNull Product product) throws Exception {
        return this.productService.saveProduct(product);
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@PathVariable Long id, @RequestBody @NotNull Product product) throws Exception {
        return this.productService.saveProduct(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public void deleteProduct(@PathVariable Long id) throws Exception {
        this.productService.deleteProduct(id);
    }
}
