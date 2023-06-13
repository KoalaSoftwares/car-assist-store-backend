package com.una.carassiststorebackend;

import com.una.carassiststorebackend.entities.Order;
import com.una.carassiststorebackend.entities.Product;
import com.una.carassiststorebackend.repositories.OrderRepository;
import com.una.carassiststorebackend.repositories.ProductRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductTests {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderTests.class);

    @Autowired
    private ProductRepository repository;

    @Test
    public void test1Creation() throws  ParseException {
        LOGGER.info("Creating objects...");
        Product p1 = new Product("Wax", BigDecimal.valueOf(32.45), "Wax to polish car");
        repository.save(p1);

        Product p2 = new Product("Glass Cleaner", BigDecimal.valueOf(90.66), "Glass cleaner");
        repository.save(p2);

        Product p3 = new Product("Plastic Restorers", BigDecimal.valueOf(12.33), "Plastic restorers");
        repository.save(p3);

        LOGGER.info("Searching all...");
        Iterable<Product> list = repository.findAll();
        assertNotNull(list.iterator());
        for (Product product : list) {
            LOGGER.info(product.toString());
        }
        LOGGER.info("Searching an object...");
        List<Product> result = repository.findByName("Wax");
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getDescription(), "Wax to polish car");
        LOGGER.info("Found: {}", result.get(0));
    }

    @Test
    public void test2Delete() throws ParseException {
        LOGGER.info("Deleting objects...");
        List<Product> result = repository.findByName("Plastic Restorers");
        for (Product product : result) {
            LOGGER.info("Deleting order id = "+product.getId());
            repository.delete(product);
        }
        result = repository.findByPrice(BigDecimal.valueOf(90.66));
        for (Product product : result) {
            LOGGER.info("Deleting order id = "+product.getId());
            repository.delete(product);
        }
        result = repository.findByName("Wax");
        for (Product product : result) {
            LOGGER.info("Deleting order id = "+product.getId());
            repository.delete(product);
        }
        result = repository.findByName("Wax");
        assertEquals(result.size(), 0);
        LOGGER.info("Delete success");
    }
}
