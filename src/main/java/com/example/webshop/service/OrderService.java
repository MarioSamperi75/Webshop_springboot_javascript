package com.example.webshop.service;

import com.example.webshop.domain.Order_Item;
import com.example.webshop.domain.Orders;
import com.example.webshop.domain.Product;
import com.example.webshop.domain.User;

import java.util.List;

public interface OrderService {

    List<Orders> findAllOrders();

    List <Orders> findOrderByUsername(String username);

    Orders findOrderByID(long id);

    List <Product> findLastCartByUsername (String username);

}