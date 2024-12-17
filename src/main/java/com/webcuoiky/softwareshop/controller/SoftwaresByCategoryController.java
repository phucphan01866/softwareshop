package com.webcuoiky.softwareshop.controller;

import com.webcuoiky.softwareshop.model.Software;
import com.webcuoiky.softwareshop.repository.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/softwares")
public class SoftwaresByCategoryController {

    @Autowired
    private SoftwareRepository repo;

    @GetMapping("/office")
    public String showOffice(Model model) {
        List<Software> softwareList = repo.findByCategory("office");
        model.addAttribute("softwares", softwareList);
        return "software/softwares";
    }

    @GetMapping("/graphic")
    public String showGraphic(Model model) {
        List<Software> softwareList = repo.findByCategory("graphic");
        model.addAttribute("softwares", softwareList);
        return "software/softwares";
    }

    @GetMapping("/sound")
    public String showSound(Model model) {
        List<Software> softwareList = repo.findByCategory("sound");
        model.addAttribute("softwares", softwareList);
        return "software/softwares";
    }

    @GetMapping("/other")
    public String showOther(Model model) {
        List<Software> softwareList = repo.findByCategory("other");
        model.addAttribute("softwares", softwareList);
        return "software/softwares";
    }
}
