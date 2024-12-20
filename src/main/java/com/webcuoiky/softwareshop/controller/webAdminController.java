package com.webcuoiky.softwareshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class webAdminController {

    @RequestMapping("")
    public  String admin() {

        return "redirect:/admin/";
    }
//    @RequestMapping("/product-list/update-product")
//    public  String productUpdate() {
//
//        return "adminPage/admin_update_product";
//    }
//    @RequestMapping("/product-list/add-product")
//    public  String productAdd() {
//
//        return "adminPage/admin_add_product";
//    }
//    @RequestMapping("/category")
//    public  String category_list() {
//
//        return "adminPage/admin_category";
//    }
//    @RequestMapping("/product-list")
//    public  String product_list() {
//
//        return "adminPage/admin_product_list";
//    }
}
