package com.webcuoiky.softwareshop.model;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;


@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Sử dụng auto-increment cho id
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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
