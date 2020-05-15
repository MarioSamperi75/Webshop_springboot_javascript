package com.example.webshop.service;

import com.example.webshop.domain.Product;
import com.example.webshop.domain.User;

import java.util.List;

public interface ProductService {
    Product findByName(String productName);

    List<Product> findAllProducts();
}
