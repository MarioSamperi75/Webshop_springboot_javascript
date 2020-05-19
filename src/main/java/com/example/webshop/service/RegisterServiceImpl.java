package com.example.webshop.service;

import com.example.webshop.domain.Product;
import com.example.webshop.domain.Response;
import com.example.webshop.domain.User;
import com.example.webshop.repository.ProductRepository;
import com.example.webshop.repository.RegisterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService{

    private RegisterRepository registerRepository;
    private static final Logger log = LoggerFactory.getLogger(RegisterServiceImpl.class);

    public RegisterServiceImpl() {}

    @Autowired
    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Transactional
    public Response addUser(User newUser) {
        registerRepository.save(newUser);

        //if något
        Response response = new Response("ADDED", true);
        return  response;
    }




}