package com.example.webshop.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "first_name", nullable = false) // 'nullable = false' = Får inte vara null.
    private String firstname;
    @Column(name = "last_name", nullable = false)
    private String lastname;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "user_name", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;
    private Role role;
    @Column(name = "totalAmount", nullable = false)
    private double totalAmount;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="user")
    private List<Orders> ordersList = new ArrayList<>();



    public User() {
    }

    public User(String firstname, String lastname, String address, String username, String password, String email, Role role, double totalAmount) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.totalAmount = totalAmount;
    }


    //-------------------------------------

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //public List<Orders> getOrdersList() {  return ordersList; }

   // public void setOrdersList(List<Orders> ordersList) { this.ordersList = ordersList; }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User {" +
                "firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
