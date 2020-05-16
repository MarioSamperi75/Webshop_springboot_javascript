package com.example.webshop.service;

import com.example.webshop.domain.Product;
import com.example.webshop.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface ProductService {
    // Visar alla produkter från DB
    List<Product> findAllProducts();

    // Visa Product från DB genom produktnamn
    Product findByName(String productName);

    // Visar produkter innehållandes {containing}
    List<Product> findByNameContaining(String containing);

}
