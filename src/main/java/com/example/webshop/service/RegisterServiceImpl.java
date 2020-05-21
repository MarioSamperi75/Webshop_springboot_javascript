package com.example.webshop.service;

import com.example.webshop.domain.*;
import com.example.webshop.repository.OrderRepository;
import com.example.webshop.repository.ProductRepository;
import com.example.webshop.repository.RegisterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService{

    private RegisterRepository registerRepository;
    private ProductServiceImpl productService;
    private UserServiceImpl userService;
    private OrderRepository orderRepository;

    private static final Logger log = LoggerFactory.getLogger(RegisterServiceImpl.class);

    public RegisterServiceImpl() {}

    @Autowired
    public RegisterServiceImpl(RegisterRepository registerRepository, ProductServiceImpl productService, UserServiceImpl userService, OrderRepository orderRepository) {
        this.registerRepository = registerRepository;
        this.productService = productService;
        this.userService = userService;
        this.orderRepository = orderRepository;
    }


    @Transactional
    public Response addUser(User newUser) {
        registerRepository.save(newUser);
        //if något
        Response response = new Response("ADDED", true);
        return  response;
    }

   @Transactional
    public Response addOrderItemLista (String username,  List<String> productListString) {
        User user = userService.findByUsername(username);
        List<Product> productList = new ArrayList<>();

        //fångar obejkt som böhövs, skapar listor som behövs, kopplar listor med objekt, sparar order
        for (int i=0; i<productListString.size(); i++){
            productList.add(productService.findByName(productListString.get(i)));
        }

        List<Orders> ordersList = user.getOrdersList();
        List<Order_Item> order_itemList = new ArrayList<>();
        Orders orders = new Orders();

        for (int i=0; i < productList.size(); i++)
            order_itemList.add(new Order_Item(orders, productList.get(i), 1));


        orders.setUser(user);
        orders.setOrder_ItemList(order_itemList);
        ordersList.add(orders);

        orderRepository.save(orders);
        log.info(String.valueOf(ordersList));








       Response response = new Response("ADDED", true);
       return  response;
    }






}