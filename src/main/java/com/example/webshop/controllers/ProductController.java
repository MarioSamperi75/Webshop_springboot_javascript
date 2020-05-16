package com.example.webshop.controllers;

import com.example.webshop.domain.Product;
import com.example.webshop.service.ProductService;
import com.example.webshop.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController

public class ProductController {

    private ProductService productService;

    public ProductController() {
    }

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/product")
    public String index() {
        return "hello Product";
    }




    //----------------Visa Product från DB  genom Username
    @RequestMapping(value = "/productName/{productName}")
    public Product findProductByName(@PathVariable String productName) { //findUserbyUsername
        return  productService.findByName(productName);

    }


    @RequestMapping(value = "/products")
    public List<Product> findAllProducts() {
        return  productService.findAllProducts();

    }

}