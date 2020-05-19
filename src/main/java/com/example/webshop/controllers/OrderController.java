package com.example.webshop.controllers;


import com.example.webshop.domain.Orders;
import com.example.webshop.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private OrderServiceImpl orderService;

    public OrderController() {}

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    //Varför leder detta till en oändlig bugg?
    @RequestMapping(value = "/orders")
    public List<Orders> findAllProducts() {
        return orderService.findAllOrders();
    }
}