package com.una.carassiststorebackend.rest;

import com.una.carassiststorebackend.business.OrderService;
import com.una.carassiststorebackend.entities.Order;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "order")
@CrossOrigin(origins = "*", allowedHeaders = {"Authorization", "Content-Type"})
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "")
    public List<Order> getOrders() {
        return this.orderService.getOrders();
    }

    @GetMapping(value = "{id}")
    public Order getOrderById(@PathVariable Long id) throws Exception {
        if (!ObjectUtils.isEmpty(id)) {
            return this.orderService.getOrderById(id);
        }
        throw new Exception("Order with id " + id + " not found");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order createOrder(@RequestBody @NotNull Order order) throws Exception {
        return this.orderService.saveOrder(order);
    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order updateOrder(@PathVariable Long id, @RequestBody @NotNull Order order) throws Exception {
        return this.orderService.saveOrder(order);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public void deleteOrder(@PathVariable Long id) throws Exception {
        this.orderService.deleteOrder(id);
    }
}
