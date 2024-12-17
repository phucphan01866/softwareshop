package com.webcuoiky.softwareshop.controller;

import com.webcuoiky.softwareshop.model.Software;
import com.webcuoiky.softwareshop.repository.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SoftwareRepository repo;

    @RequestMapping("/software/search")
    public String searchSoftware(Model model,
                                 @RequestParam String category,
                                 @RequestParam String name) {
        if (category==null || category.isEmpty()){
            if(name==null || name.isEmpty()){
                model.addAttribute("softwareSearch", repo.findAll());
                return "software/softwares_search";
            }
            else{
                List<Software> softwareSearch = repo.findByNameContaining(name);
                model.addAttribute("softwareSearch", softwareSearch);
                return "software/softwares_search";
            }
        }
        List<Software> softwareSearch = repo.findByNameContainingAndCategory(name, category);
        model.addAttribute("softwareSearch", softwareSearch);
        return "software/softwares_search";
    }

}
