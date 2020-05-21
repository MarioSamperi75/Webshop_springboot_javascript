package com.example.webshop.controllers;

import com.example.webshop.domain.InputPack;
import com.example.webshop.domain.Response;
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

    // TODO: 2020-05-19 Se över login funktionen och se vad den behöver returnera
    @PostMapping("/login")
    public Response login(@RequestBody User user) {
        Response response=new Response("Not logged in",false);
        log.info("user: " + user);
        boolean validUser = userService.verifyUserAndPass(user);
        if(validUser) {
            response.setStatus(true);
            response.setMessage("Logged in!");
        }
        log.info("response -----> " + response.getMessage());
        return response;
    }

    //flytta till register?
    @PostMapping("/user/addNewOrder")
    public Response addNewOrder(@RequestBody InputPack inputPack) {
        String username = inputPack.getUsername();
        List<String> productList = inputPack.getProductList();
        registerService.addOrderItemLista(username, productList);





        Response response=new Response("Order Added",false);


        // TODO: 2020-05-17 if satsen kollar om newUser.get.. inte är null.
        //  Om användaren submittar ett tomt värde så blir newUser.get.. = "", dvs en tom String.
        //  if satsen kommer därför aldrig gå till else


        return response;
    }



}