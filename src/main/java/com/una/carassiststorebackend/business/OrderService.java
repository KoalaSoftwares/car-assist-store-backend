package com.una.carassiststorebackend.business;

import com.una.carassiststorebackend.entities.Order;
import com.una.carassiststorebackend.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.IteratorUtils;

import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        if (logger.isInfoEnabled()) {
            logger.info("Searching all orders");
        }
        Iterable<Order> list = this.orderRepository.findAll();

        return IteratorUtils.toList(list.iterator());
    }

    public Order getOrderById(Long id) {
        if(logger.isInfoEnabled()){
            logger.info("Searching order with id {}",id);
        }
        Optional<Order> res = this.orderRepository.findById(id);

        if(res.isEmpty()){
            throw new RuntimeException("Order with id "+id+" not found");
        }
        return res.get();
    }

    public List<Order> getOrdersByTotalPrice(BigDecimal totalPrice) {
        if(logger.isInfoEnabled()){
            logger.info("Searching order with total price {}",totalPrice);
        }
        List<Order> res = this.orderRepository.findByTotalPrice(totalPrice);

        return IteratorUtils.toList(res.iterator());
    }

    public List<Order> getOrdersByPaymentType(String paymentType) {
        if(logger.isInfoEnabled()){
            logger.info("Searching order with payment type {}",paymentType);
        }
        List<Order> res = this.orderRepository.findByPaymentType(paymentType);

        return IteratorUtils.toList(res.iterator());
    }

    public Order saveOrder(Order order) {
        if(logger.isInfoEnabled()){
            logger.info("Saving order with details {}",order.toString());
        }

        return this.orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        if(logger.isInfoEnabled()){
            logger.info("Deleting order with id {}",id);
        }

        this.orderRepository.deleteById(id);
    }

    public boolean isOrderExists(Order order){
        Optional<Order> res = this.orderRepository.findById(order.getId());
        return res.isPresent();
    }
}
