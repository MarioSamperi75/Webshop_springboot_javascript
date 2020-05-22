package com.example.webshop.service;

import com.example.webshop.domain.*;
import com.example.webshop.repository.OrderRepository;
import com.example.webshop.repository.ProductRepository;
import com.example.webshop.repository.RegisterRepository;
import com.example.webshop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class RegisterServiceImpl implements RegisterService{

    private RegisterRepository registerRepository;
    private ProductServiceImpl productService;
    private UserServiceImpl userService;
    private OrderRepository orderRepository;
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(RegisterServiceImpl.class);


    public RegisterServiceImpl() {}

    @Autowired
    public RegisterServiceImpl(RegisterRepository registerRepository, ProductServiceImpl productService,
                               UserServiceImpl userService, OrderRepository orderRepository,
                               UserRepository userRepository) {
        this.registerRepository = registerRepository;
        this.productService = productService;
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }


    @Transactional
    public Response addUser(User newUser) {
        registerRepository.save(newUser);
        //if något
        Response response = new Response("ADDED", true);
        return  response;
    }

   @Transactional
    public Response addOrderItemLista (String username,  List<String> productListString, double total) {
        //andas djupt... gå!!!

       //fångar obejkt som böhövs, skapar listor som behövs, kopplar listor med objekt, sparar order, uppdate user total amoun
        User user = userService.findByUsername(username);
        List<Product> productList = new ArrayList<>();

        //uppdate total amount och spara user
        log.info("user : " +user.getUsername());
        user.setTotalAmount(user.getTotalAmount() + total);
        userRepository.save(user);

        //gå genom list med productnamn och skapa en produktList (objekt product inte bara namn)
        for (int i=0; i<productListString.size(); i++){
            productList.add(productService.findByName(productListString.get(i)));
        }

        //tar lista med alla Orders (user + inköpslista) skapa ny inköpslista, skapa en ny Orders
        List<Orders> ordersList = user.getOrdersList();
        List<Order_Item> order_itemList = new ArrayList<>();
        Orders orders = new Orders();

        //går igenom product lista tar varje product och skapar alla orderitems (order +product + quantity)
        //stoppar allt det i en order_itemList (inköpslista)
        for (int i=0; i < productList.size(); i++)
            order_itemList.add(new Order_Item(orders, productList.get(i), 1));

        //setters för order som skapade med costructor()
        orders.setUser(user);
        orders.setOrder_ItemList(order_itemList);
        ordersList.add(orders);

        //sparar order (som är kopplad med user)
        orderRepository.save(orders);









       Response response = new Response("ADDED", true);
       return  response;
    }






}