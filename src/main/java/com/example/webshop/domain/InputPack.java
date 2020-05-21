package com.example.webshop.domain;

import java.util.List;

public class InputPack {

    private String username;
    private List<String> productList;


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
}
