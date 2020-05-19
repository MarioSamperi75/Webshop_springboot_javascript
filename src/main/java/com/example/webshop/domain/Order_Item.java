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
    private int quantity;

//-----------------------------------------

    public Order_Item() {
    }

    public Order_Item(Orders orders, Product product, int quantity) {
        this.orders = orders;
        this.product = product;
        this.quantity = quantity;
    }

//-----------------------------------------


    public Long getId() {
        return id;
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}