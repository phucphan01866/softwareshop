package com.webcuoiky.softwareshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//http:/www.thymeleaf.com
//localhost:8080/
@Controller
public class webBasicController {
    @RequestMapping(value={"/","/index"})
    public String index() {

        return "index";
    }
    @RequestMapping("/checkout")
    public String checkout() {

        return "checkout";
    }
    @RequestMapping("/product")
    public String product() {

        return "product";
    }
    @RequestMapping("/category")
    public String category() {
    
        return "category";
    }
    @RequestMapping("/login")
    public String login() {

        return "login";
    }
    @RequestMapping("/register")
    public String regis() {

        return "register";
    }
}
