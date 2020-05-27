package com.example.webshop.domain;

import java.util.List;

//Data objekt som vi skickar genom javascript och som inehåller all relevant som vi behöver att uppdatera database
public class InputPack {

    private String username;
    private List<String> productList;
    private double total;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        this.productList = productList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
