package com.example.webshop.service;

import com.example.webshop.domain.*;
import com.example.webshop.repository.OrderRepository;
import com.example.webshop.repository.ProductRepository;
import com.example.webshop.repository.RegisterRepository;
import com.example.webshop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService{

    private RegisterRepository registerRepository;
    private ProductServiceImpl productService;
    private UserServiceImpl userService;
    private OrderRepository orderRepository;
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(RegisterServiceImpl.class);

    public RegisterServiceImpl() {}

    @Autowired
    public RegisterServiceImpl(
            RegisterRepository registerRepository,
            ProductServiceImpl productService,
            UserServiceImpl userService,
            OrderRepository orderRepository,
            UserRepository userRepository
    ) {
        this.registerRepository = registerRepository;
        this.productService = productService;
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }


    @Transactional
    public Response addUser(User newUser) {
        Response response = new Response("", false);
        // Kolla om något värde är en tom sträng. Skicka tillbaka ett response i så fall.
        if(newUser.getFirstname().equals("") || newUser.getLastname().equals("") || newUser.getAddress().equals("")
                || newUser.getUsername().equals("") || newUser.getPassword().equals("") || newUser.getEmail().equals("") ) {
            response.setMessage("Något gick fel. Användaren har inte blivit registrerad");
            return response;
        }
        // Kolla om användarnamn redan är registrerat. Skicka tillbaka ett response i så fall.
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(newUser.getUsername())) {
                response.setMessage("Användarnamnet är upptaget. Pröva ett annat");
                return response;
            }
        }
        // Spara användaren och skicka tillbaka ett respons
        registerRepository.save(newUser);
        response.setMessage("Användare registrerad!");
        response.setStatus(true);
        return response;
    }

   @Transactional
    public Response addOrderItemLista (String username,  List<String> productListString) {
        User user = userService.findByUsername(username);
        List<Product> productList = new ArrayList<>();

        //fångar obejkt som böhövs, skapar listor som behövs, kopplar listor med objekt, sparar order
        for (int i=0; i<productListString.size(); i++){
            productList.add(productService.findByName(productListString.get(i)));
        }

        List<Orders> ordersList = user.getOrdersList();
        List<Order_Item> order_itemList = new ArrayList<>();
        Orders orders = new Orders();

        for (int i=0; i < productList.size(); i++)
            order_itemList.add(new Order_Item(orders, productList.get(i), 1));


        orders.setUser(user);
        orders.setOrder_ItemList(order_itemList);
        ordersList.add(orders);

        orderRepository.save(orders);
        log.info(String.valueOf(ordersList));








       Response response = new Response("ADDED", true);
       return  response;
    }






}