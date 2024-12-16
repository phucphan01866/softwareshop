package com.webcuoiky.softwareshop.controller;

import com.webcuoiky.softwareshop.model.Software;
import com.webcuoiky.softwareshop.repository.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("index")
public class IndexController
{
    @Autowired
    private SoftwareRepository repo;

    @GetMapping
    public String showIndex(@RequestParam(value = "other", required = false) String other,
                            @RequestParam(value = "graphic", required = false) String graphic,
                            @RequestParam(value = "sound", required = false) String sound,
                            Model model) {
        List<Software> softwareList;

        // Kiểm tra từng tham số có trong URL
        if (other != null) {
            softwareList = repo.findByCategory("other");
        } else if (graphic != null) {
            softwareList = repo.findByCategory("graphic");
        } else if (sound != null) {
            softwareList = repo.findByCategory("sound");
        } else {
            // Mặc định nếu không có tham số nào
            softwareList = repo.findByCategory("office");
        }

        softwareList.sort(Comparator.comparingInt(Software::getId).reversed());

        int limit = 4;
        if (softwareList.size() > limit) {
            softwareList = softwareList.subList(0, limit);
        }

        System.out.println("Số sản phẩm lấy được: " + softwareList.size());
        model.addAttribute("softwaresOffice", softwareList);
        return "index";
    }
}
