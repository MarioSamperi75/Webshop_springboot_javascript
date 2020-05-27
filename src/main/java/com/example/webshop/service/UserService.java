package com.example.webshop.service;

import com.example.webshop.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findByUsername(String username);

    List<User> findAllUsers();

    Optional<User> verifyUserAndPass(User user);
}
