package com.example.webshop;

import com.example.webshop.domain.*;
import com.example.webshop.repository.OrderRepository;
import com.example.webshop.repository.ProductRepository;
import com.example.webshop.repository.UserRepository;
import com.example.webshop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShopApplication {


    public static void main(String[] args) {
        SpringApplication.run(com.example.webshop.ShopApplication.class, args);

    }

    @Autowired
    private UserRepository userRepository;


    @Bean
    public CommandLineRunner setUp(UserRepository userRepository, ProductRepository productRepository, OrderRepository orderRepository, UserServiceImpl userService){
        return  (args -> {
            User user1 = new User ("Göran","Customersson","Customergatan 9","customer", "customer123", "goran@mail.com", Role.CUSTOMER, 0);
            User user2 = new User("Fredrik","Premiumsson","Preiumvägen 7","premium", "premium123", "fredrik@mail.com", Role.PREMIUM_CUSTOMER, 500);
            User user3 = new User("Albert","Adminsson", "Adminvägen 67", "admin", "admin123", "admin@mail.com", Role.ADMIN, 0);

            Product product1 = new Product("Dillchips", "Smakfulla dillchips från OLW!", 20.0D);
            Product product2 = new Product("Sourcream", "Delikata sorucreamchips från OLW!", 20.0D);
            Product product3 = new Product("Grillchips", "Krispiga grillchips från OLW!", 20.0D);


            //1. Skapa tomma orders
            Orders  orders1 = new Orders();
            Orders  orders2 = new Orders();
            Orders  orders3 = new Orders();

            //2. skapa ORDER ITEMS
            Order_Item order_item1 = new Order_Item(orders1, product1);
            Order_Item order_item2 = new Order_Item(orders1, product2);
            Order_Item order_item3 = new Order_Item(orders1, product3);

            //3.skapa och fylla lista ORDER ITEMS
            List<Order_Item> order_itemList1 = new ArrayList<>();
            order_itemList1.add(order_item1);
            order_itemList1.add(order_item2);
            order_itemList1.add(order_item3);

            //4. Fylla order med user och Lista order items
            orders1.setUser(user1);
            orders1.setOrder_ItemList(order_itemList1);


            //igen: 2. 3. 4.
            Order_Item order_item4 = new Order_Item(orders2, product3);
            List<Order_Item> order_itemList2 = new ArrayList<>();
            order_itemList2.add(order_item4);
            orders2.setUser(user1);
            orders2.setOrder_ItemList(order_itemList2);




            userRepository.save(user1);
            userRepository.save( user2);
            userRepository.save( user3);

            productRepository.save( product1);
            productRepository.save( product2);
            productRepository.save( product3);

            orderRepository.save( orders1);
            orderRepository.save( orders2);


            userService.findByUsername("customer");

        });


    }
}
