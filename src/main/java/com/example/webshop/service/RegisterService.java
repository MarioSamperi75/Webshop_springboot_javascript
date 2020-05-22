package com.example.webshop.service;

import com.example.webshop.domain.Product;
import com.example.webshop.domain.Response;
import com.example.webshop.domain.User;

import java.util.List;

public interface RegisterService {
    Response addUser(User newUser);

    Response addOrderItemLista(String username, List<String> productList, double total);

}
