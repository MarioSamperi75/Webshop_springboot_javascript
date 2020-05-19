package com.example.webshop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORDER_ITEM")
public class Order_Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Orders orders;
    @ManyToOne
    private Product product;

//-----------------------------------------

    public Order_Item() {
    }

    public Order_Item(Orders orders, Product product) {
        this.orders = orders;
        this.product = product;
    }

//-----------------------------------------


    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}