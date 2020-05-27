package com.example.webshop;

import com.example.webshop.domain.*;
import com.example.webshop.repository.ProductRepository;
import com.example.webshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.example.webshop.ShopApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;


    @Bean
    public CommandLineRunner setUp(UserRepository userRepository, ProductRepository productRepository) {
        return  (args -> {
            User user1 = new User ("Göran","Customersson","Customergatan 9","customer", "customer123", "goran@mail.com", Role.CUSTOMER, 0);
            User user2 = new User ("Stefan","Stefansson","Stefansvägen 9","stefan", "stefan123", "stefan@mail.com", Role.CUSTOMER, 0);
            User user3 = new User("Fredrik","Premiumsson","Premiumvägen 7","premium", "premium123", "fredrik@mail.com", Role.PREMIUM_CUSTOMER, 500);
            User user4 = new User("Albert","Adminsson", "Adminvägen 67", "admin", "admin123", "admin@mail.com", Role.ADMIN, 0);

            Product product1 = new Product("Dillchips",     "Smakfulla dillchips från OLW!", 20.0D);
            Product product2 = new Product("Sourcream",     "Delikata sorucreamchips från OLW!", 20.0D);
            Product product3 = new Product("Grillchips",    "Krispiga grillchips från OLW!", 20.0D);
            Product product4 = new Product("Cream Cheese",  "Tunna potatischips med färskost!", 20.0D);
            Product product5 = new Product("Cheddar Royale","Grovräfflade chips med cheddar!", 20.0D);
            Product product6 = new Product("Hot Ranch",     "Nu hetare en nånsin!", 20.0D);

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);
            productRepository.save(product5);
            productRepository.save(product6);
        });
    }
}