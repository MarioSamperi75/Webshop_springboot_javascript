package com.example.webshop.controllers;

import com.example.webshop.domain.User;
import com.example.webshop.service.UserService;
import com.example.webshop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController() {
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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

}
