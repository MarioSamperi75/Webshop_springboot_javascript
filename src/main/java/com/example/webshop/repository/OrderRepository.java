package com.example.webshop.repository;

import com.example.webshop.domain.Orders;
import com.example.webshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {



}