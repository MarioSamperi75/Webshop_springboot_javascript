package com.example.webshop.controllers;

import com.example.webshop.domain.Product;
import com.example.webshop.service.ProductService;
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

    // Visar alla produkter från DB
    @RequestMapping(value = "/products")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    // Visa Product från DB genom produktnamn
    @RequestMapping(value = "/productName/{productName}")
    public Product findProductByName(@PathVariable String productName) {
        return productService.findByName(productName);
    }

    // Visar produkter innehållandes {containing}
    @RequestMapping(value = "/searchProductContaining/{containing}")
    public List<Product> findByNameContaining(@PathVariable String containing) {
        return productService.findByNameContaining(containing);
    }
}