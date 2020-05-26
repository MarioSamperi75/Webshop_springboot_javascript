package com.example.webshop.service;

import com.example.webshop.domain.Order_Item;
import com.example.webshop.domain.Orders;
import com.example.webshop.domain.Product;
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

    //från en order, tar vi sista ordetItemlista och extraherar en lista med product :)
    @Override
    public List <Product> findLastCartByUsername (String username){
        int size = findOrderByUsername(username).size() -1;
        List<Order_Item> order_itemList= findOrderByUsername(username).get(size).getOrder_ItemList();
        List<Product> productList = new ArrayList<>();
        for(Order_Item orderItem : order_itemList)
            productList.add(orderItem.getProduct());
            return productList;
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