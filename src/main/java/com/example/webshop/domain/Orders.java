package com.example.webshop.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "findAllOrders", query = "SELECT o FROM Orders o")
})

@Entity
@Table(name = "ORDERS")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    private long id;
    @ManyToOne
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="orders")
    private List<Order_Item> order_ItemList = new ArrayList<>();


    //-------------------------------------

    public Orders() {
    }

    public Orders(User user, List<Order_Item> order_itemList) {
        this.user = user;
        this.order_ItemList = order_itemList;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order_Item> getOrder_ItemList() {
        return order_ItemList;
    }

    public void setOrder_ItemList(List<Order_Item> order_ItemList) {
        this.order_ItemList = order_ItemList;
    }
}