package com.webcuoiky.softwareshop.controller;

import com.webcuoiky.softwareshop.model.Software;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SoftwaresController {

    @Autowired
    SessionFactory factory;
    @RequestMapping("softwares")
    public String showSoftwares(ModelMap model) {
        return "software/softwares";
    }

    @ModelAttribute("softwares")
    public List<Software> getSoftwares() {
        Session session = factory.openSession();
        String hql ="FROM Software";
        Query query = session.createQuery(hql);
        List<Software> list = query.list();
        return list;
    }

    @RequestMapping("/software_detail/{id}")
    public String softwareDetail(@PathVariable ("id") int id, ModelMap model) {
        Session session = factory.openSession();
        Software software = (Software) session.get(Software.class, id);
        model.addAttribute("software_detail", software);
        return "software/software_detail";
    }
}
