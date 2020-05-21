package com.example.webshop.controllers;

import com.example.webshop.domain.Response;
import com.example.webshop.domain.User;
import com.example.webshop.service.ProductServiceImpl;
import com.example.webshop.service.RegisterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @RequestMapping("/register")
    public String index() {
        return "hello Register";
    }

    @PostMapping("/user/add")
    public Response addUser(@RequestBody User newUser) {
        log.info("user från registerController" + newUser);
        Response response=new Response("User added",false);
        // TODO: 2020-05-17 if satsen kollar om newUser.get.. inte är null.
        //  Om användaren submittar ett tomt värde så blir newUser.get.. = "", dvs en tom String.
        //  if satsen kommer därför aldrig gå till else
        if((newUser.getFirstname()!=null) &&(newUser.getLastname()!=null) && newUser.getAddress()!=null
            && newUser.getUsername()!=null && newUser.getPassword()!=null && newUser.getEmail()!=null ) {
            registerService.addUser(newUser);
            response.setStatus(true);
        }
        else {
            response.setMessage("failed to add");
        }
        log.info(response.getMessage());
        log.info("user från registerController" + newUser);
        return response;
    }


}