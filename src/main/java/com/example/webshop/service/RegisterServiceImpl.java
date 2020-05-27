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
import java.util.Properties;

@Service
public class RegisterServiceImpl implements RegisterService {

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
    public Response addOrderItemLista (String username,  List<String> productListString, double total) {
        //andas djupt... gå!!!

        // ATT SKAPA EN ORDERS INNEBÄR:

        //0. Man måste ha objekt user och productsList (Product inte bara namn!) och total (titta parametrar)
        //1. Skapa en tom Orders
        //2 .skapa en tom ORDER ITEMS list
        //3. skapa en eller flera ORDER ITEMS (Orders + Product + int quantity)
        //4  fylla ORDER ITEMS list
        //5. Set user och OrderItems List i Orders som var tom
        //6. Ta och uppdatera Users ordersList (lista med alla beställningar)
        //7. spara order
        //8. uppdate user total amoun, uppdate role (eventuellt)  (bättre att dela i flera metoder)

        //0. get motsvarade user och skapa en productList att fylla i
        User user = userService.findByUsername(username);
        List<Product> productList = new ArrayList<>();


        //0. gå genom list med productnamn och skapa en productList (objekt product inte bara namn)
        for (int i=0; i<productListString.size(); i++){
            productList.add(productService.findByName(productListString.get(i)));
        }

        //1. skapa en ny Orders, ta listan med alla Orders (Orders = user + inköpslista)
        Orders orders = new Orders();

        //2. skapa ny inköpslista (Order_ItemList)
        List<Order_Item> order_itemList = new ArrayList<>();

        //3.4. går igenom productList tar varje product och skapar alla orderitems (order +product + quantity)
        //stoppar alla order_items i order_itemList
        for (int i=0; i < productList.size(); i++)
            order_itemList.add(new Order_Item(orders, productList.get(i), 1));

        //5. setters för att fylla den tomma Orders och uppdatera Users orderlist
        orders.setUser(user);
        orders.setOrder_ItemList(order_itemList);

        //6. Ta och uppdatera Users ordersList (lista med alla beställningar)
        List<Orders> ordersList = user.getOrdersList();
        ordersList.add(orders);

        //7. sparar order (som är kopplad med user)
        orderRepository.save(orders);

       //8. uppdate total amount, eventuellt role (Premium villkor!), och spara user
       user.setTotalAmount(user.getTotalAmount() + total);
       if (user.getTotalAmount()>=500)
           user.setRole(Role.PREMIUM_CUSTOMER);
       userRepository.save(user);

        Response response = new Response("ADDED", true);
        return response;
    }
}