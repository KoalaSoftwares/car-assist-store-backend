package com.una.carassiststorebackend.repositories;

import com.una.carassiststorebackend.entities.Order;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findBy(BigDecimal totalPrice);

    List<Order> findByPaymentType(String paymentType);

    Order findById(long id);
}
