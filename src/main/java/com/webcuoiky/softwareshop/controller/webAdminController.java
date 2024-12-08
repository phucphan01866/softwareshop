package com.webcuoiky.softwareshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class webAdminController {
    @RequestMapping("product")
    public  String product() {

        return "admin_product";
    }
}
