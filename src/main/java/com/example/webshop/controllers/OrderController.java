package com.example.webshop.controllers;


import com.example.webshop.domain.Order_Item;
import com.example.webshop.domain.Orders;
import com.example.webshop.domain.Product;
import com.example.webshop.domain.User;
import com.example.webshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    //----------------Visa User från DB  genom Username
    @RequestMapping(value = "/orderByUsername/{username}")
    public List <Orders> findOrderByUsername(@PathVariable String username) {
        return orderService.findOrderByUsername(username);
    }

    @RequestMapping(value = "/lastCart/{username}")
    public List <Product> findLastCart(@PathVariable String username) {
        return orderService.findLastCartByUsername(username);
    }



    @RequestMapping(value = "/orderByID/{id}")
    public Orders findOrderByID(@PathVariable long id) {
        return orderService.findOrderByID(id);
    }
}