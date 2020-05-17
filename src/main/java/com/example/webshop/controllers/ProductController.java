package com.example.webshop.controllers;

import com.example.webshop.domain.Product;
import com.example.webshop.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController

public class ProductController {

    private ProductServiceImpl productService;

    public ProductController() {}

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @RequestMapping("/product")
    public String index() {
        return "hello Product";
    }

    //----------------Visa Product från DB  genom Username
    @RequestMapping(value = "/productByProductname/{productName}")
    public Product findUserbyUsername(@PathVariable String productName) {
        return  productService.findByName(productName);
    }

    @RequestMapping(value = "/products")
    public List<Product> findAllProducts() {
        return  productService.findAllProducts();
    }
}