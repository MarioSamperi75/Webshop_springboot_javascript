package com.example.webshop.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PRODUCT")

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private double price;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="product")
    private List<Order_Item> order_itemList;
//-----------------------------------------

    public Product() {
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
//-----------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //public List<Orders> getOrdersList() {
    //    return ordersList;
    //}

    //public void setOrdersList(List<Orders> ordersList) {
    //    this.ordersList = ordersList;
    //}

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", description=" + description + ", pris=" + price + "}";
    }
}