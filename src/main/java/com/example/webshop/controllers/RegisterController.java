package com.example.webshop.controllers;

import com.example.webshop.domain.Response;
import com.example.webshop.domain.User;
import com.example.webshop.service.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    private RegisterServiceImpl registerService;

    public RegisterController() {
    }

    @Autowired
    public RegisterController(RegisterServiceImpl registerService) {
        this.registerService = registerService;
    }

    @RequestMapping("/register")
    public String index() {
        return "hello Register";
    }

    @PostMapping("/user/add")
    public Response addUser(@RequestBody User newUser) {
        return registerService.addUser(newUser);
    }


}