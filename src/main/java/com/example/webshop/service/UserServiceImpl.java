package com.example.webshop.service;

import com.example.webshop.domain.User;
import com.example.webshop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl() {}

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        log.info("findByUsername " + result);
        return result;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean verifyUserAndPass(User user) {
        List<User> users = userRepository.findAll();

        for (User userInDB : users) {
            if(user.getUsername().equalsIgnoreCase(userInDB.getUsername())) {
                if(user.getPassword().equals(userInDB.getPassword())) {
                    return true;
                }
            }
        }
        return false;
    }

}