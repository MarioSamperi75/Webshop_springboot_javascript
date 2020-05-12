package com.example.webshop.service;

import com.example.webshop.domain.User;
import com.example.webshop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl() {}

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        log.info("findByUsername " + result);
        return  result;
    }

    public List<User> findAllUsers(){ return userRepository.findAll(); }

     /*result = addressRepository.findByStreetname("Södervägen");
        log.info("findByStreet" + result);
        result = addressRepository.findByStreetnameAndCity("Solna","Södervägen");
        log.info("findByStreetnameAndCity" + result);
        result = addressRepository.findByPostalCodeIsLessThan(456);
        log.info("findByPostalCodeIsLessThan" + result);
        result = addressRepository.findByPostalCodeIsLessThan(456);
        log.info("findByPostalCodeIsLessThan" + result);
        result = addressRepository.findByCityStartingWith("S");
        log.info("findByCityStartingWith" + result);
        result = addressRepository.findByCityContaining("l");
        log.info("findByCityContaining" + result);
        result = addressRepository.bothSame("Halmstad");
        log.info("bothSame" + result);*/
}