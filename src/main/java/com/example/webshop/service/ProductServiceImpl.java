package com.example.webshop.service;

import com.example.webshop.domain.Product;
import com.example.webshop.domain.User;
import com.example.webshop.repository.ProductRepository;
import com.example.webshop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl() {}

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findByName(String productName) {
        Product result = productRepository.findByName(productName);
        log.info("findByProductByname " + result);
        return  result;
    }

    public List<Product> findAllProducts(){ return productRepository.findAll(); }


}