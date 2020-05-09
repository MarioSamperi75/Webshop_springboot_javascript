package com.example.webshop.persistence;/*package com.webshop.shop.persistence;

import javax.persistence.*;
import java.io.Serializable;
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
    @JoinTable(name = "product_in_order",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) //La till
    private List<Product> productList;
    //-------------------------------------

    public Orders() {
    }

    public Orders(User user, List<Product> productList) {
        this.user = user;
        this.productList = productList;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}*/