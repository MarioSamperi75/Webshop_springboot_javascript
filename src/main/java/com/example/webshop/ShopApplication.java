package com.example.webshop;

import com.example.webshop.persistence.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.example.webshop.ShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner setUp(UserRepository userRepository, ProductRepository productRepository){
        return  (args -> {
            userRepository.save( new User("Göran","Customersson","Customergatan 9","customer", "customer123", "goran@mail.com", Role.CUSTOMER, 0));
            userRepository.save( new User("Fredrik","Premiumsson","Preiumvägen 7","premium", "premium123", "fredrik@mail.com", Role.PREMIUM_CUSTOMER, 500));
            userRepository.save( new User("Albert","Adminsson", "Adminvägen 67", "admin", "admin123", "admin@mail.com", Role.ADMIN, 0));

            productRepository.save( new Product("Dillchips", "Smakfulla dillchips från OLW!", 20.0D));
            productRepository.save( new Product("Sourcream", "Delikata sorucreamchips från OLW!", 20.0D));
            productRepository.save( new Product("Grillchips", "Krispiga grillchips från OLW!", 20.0D));


        });


    }
}
