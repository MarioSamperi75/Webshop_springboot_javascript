package com.example.webshop.controllers;

import com.example.webshop.domain.InputPack;
import com.example.webshop.domain.Response;
import com.example.webshop.domain.Role;
import com.example.webshop.domain.User;
import com.example.webshop.service.ProductServiceImpl;
import com.example.webshop.service.RegisterService;
import com.example.webshop.service.UserService;
import com.example.webshop.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private UserService userService;
    private RegisterService registerService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService, RegisterService registerService) {
        this.userService = userService;
        this.registerService = registerService;
    }

    @RequestMapping("/user")
    public String index() {
        return "hello User";
    }

    //----------------Visa User från DB  genom Username
    @RequestMapping(value = "/userByUsername/{username}")
    public User findUserbyUsername(@PathVariable String username) {
        return  userService.findByUsername(username);
    }

    @RequestMapping(value = "/users")
    public List<User> findAllUsers() {
        return  userService.findAllUsers();
    }

    @PostMapping("/login")
    public Response login(@RequestBody User user) {
        Response response = new Response("Not logged in",false);
        Optional<User> validUser = userService.verifyUserAndPass(user);

        validUser.ifPresent(theUser -> {
            response.setStatus(true);
            if (theUser.getRole() != Role.ADMIN) {
                response.setMessage("Customer logged in");
            } else {
                response.setMessage("Admin logged in");
            }
            log.info("validUser: " + validUser);
        });

        log.info("response -----> " + response.getMessage());
        log.info("response -----> " + response.getStatus());
        return response;
    }

    //flytta till register?
    @PostMapping("/user/addNewOrder")
    public Response addNewOrder(@RequestBody InputPack inputPack) {
        String username = inputPack.getUsername();
        List<String> productList = inputPack.getProductList();
        double total = inputPack.getTotal();
        registerService.addOrderItemLista(username, productList, total);

        Response response=new Response("Order Added",false);
        return response;
    }



}