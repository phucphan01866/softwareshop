package com.webcuoiky.softwareshop.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table
public class User {
    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String role;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<Order> orders;

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<com.webcuoiky.softwareshop.model.Order> getOrders() {
        return orders;
    }

    public void setOrders(Collection<com.webcuoiky.softwareshop.model.Order> orders) {
        this.orders = orders;
    }
}
