package com.example.webshop.service;

import com.example.webshop.domain.User;

import java.util.List;

public interface UserService {
    public User findByUsername(String username);

    public List<User> findAllUsers();
}
