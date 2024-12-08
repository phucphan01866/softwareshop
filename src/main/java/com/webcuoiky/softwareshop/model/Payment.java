package com.webcuoiky.softwareshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;


public class Payment {
    private Integer id;
    private Date date;
    private Integer order_id;
}
