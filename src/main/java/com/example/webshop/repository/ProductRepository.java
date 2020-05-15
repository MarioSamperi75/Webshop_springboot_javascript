package com.example.webshop.repository;

import com.example.webshop.domain.Product;
import com.example.webshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String productName);

}