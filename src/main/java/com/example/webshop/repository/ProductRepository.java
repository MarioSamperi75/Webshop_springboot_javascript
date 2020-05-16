package com.example.webshop.repository;

import com.example.webshop.domain.Product;
import com.example.webshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Visa Product från DB genom produktnamn
    Product findByNameIgnoreCase(String productName);

    // Visar produkter innehållandes {containing}
    List<Product> findByNameContainingIgnoreCase(String containing);
}