package com.una.carassiststorebackend;

import com.una.carassiststorebackend.entities.Order;
import com.una.carassiststorebackend.repositories.OrderRepository;
import org.springframework.boot.test.context.SpringBootTest;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderTests {

    private static Logger LOGGER = LoggerFactory.getLogger(OrderTests.class);
    private  SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");

    @Autowired
    private OrderRepository repository;

    @Test
    public void test1Creation() throws ParseException, InterruptedException {
        LOGGER.info("Creating objects...");
        Order o1 = new Order("xyn", BigDecimal.valueOf(50.60), df.parse("05/06/2023"), "Debit");
        repository.save(o1);

        Order o2 = new Order("xyn2", BigDecimal.valueOf(50.69), df.parse("10/09/2023"), "Credit");
        repository.save(o2);

        Order o3 = new Order("xyn1", BigDecimal.valueOf(50.68), df.parse("30/12/2022"), "Cash");
        repository.save(o3);

        LOGGER.info("Searching all...");
        Iterable<Order> list = repository.findAll();
        assertNotNull(list.iterator());
        for (Order order : list) {
            LOGGER.info(order.toString());
        }
        LOGGER.info("Searching an object...");
        List<Order> result = repository.findByPaymentType("Credit");
        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getTotalPrice(), BigDecimal.valueOf(50.69));
        LOGGER.info("Found: {}", result.get(0));
    }

    @Test
    public void test2Delete() throws ParseException {
        LOGGER.info("Deleting objects...");
        List<Order> result = repository.findByPaymentType("Debit");
        for (Order order : result) {
            LOGGER.info("Deleting order id = "+order.getId());
            repository.delete(order);
        }
        result = repository.findByTotalPrice(BigDecimal.valueOf(12.33));
        for (Order order : result) {
            LOGGER.info("Deleting order id = "+order.getId());
            repository.delete(order);
        }
        result = repository.findByPaymentType("Credit");
        for (Order order : result) {
            LOGGER.info("Deleting order id = "+order.getId());
            repository.delete(order);
        }
        result = repository.findByPaymentType("Debit");
        assertEquals(result.size(), 0);
        LOGGER.info("Delete success");
    }
}
