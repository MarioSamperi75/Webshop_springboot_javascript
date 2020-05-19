package com.example.webshop.controllers;


import com.example.webshop.domain.Orders;
import com.example.webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController() {}

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/orders")
    public List<Orders> findAllOrders() {
        return orderService.findAllOrders();
    }
}