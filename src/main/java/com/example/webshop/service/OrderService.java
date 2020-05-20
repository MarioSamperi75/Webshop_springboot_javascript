package com.example.webshop.service;

import com.example.webshop.domain.Orders;
import com.example.webshop.domain.Product;
import com.example.webshop.domain.User;

import java.util.List;

public interface OrderService {
    //Product findByName(String productName);

    List<Orders> findAllOrders();

    List <Orders> findOrderByUsername(String username);

}
