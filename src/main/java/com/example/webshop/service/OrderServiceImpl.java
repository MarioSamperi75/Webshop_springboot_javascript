package com.example.webshop.service;

import com.example.webshop.domain.Orders;
import com.example.webshop.domain.User;
import com.example.webshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl() {}

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Orders> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List <Orders> findOrderByUsername(String username) {
        List <Orders> temp = new ArrayList<>();
        for(Orders orders : orderRepository.findAll()) {
            if(orders.getUser().getUsername().equals(username)) {
               temp.add(orders);
            }
        }
        return temp;
    }

    @Override
    public Orders findOrderByID(long id) {
        Orders temp = null;
        for(Orders orders : orderRepository.findAll()) {
            if(orders.getId() == id) {
                temp = orders;
            }
        }
        return temp;
    }
}