package com.webcuoiky.softwareshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;


public class Order {
    @Id
    private Integer id;
    private Float cost;
    private String name;
    private String email;
    private String status;
    private String address;
    private String phone;
    private Date date;

}
