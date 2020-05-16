package com.example.webshop.repository;

import com.example.webshop.domain.Orders;
import com.example.webshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<User, Long> {


}