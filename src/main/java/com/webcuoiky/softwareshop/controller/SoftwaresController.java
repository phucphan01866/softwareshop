package com.webcuoiky.softwareshop.controller;

import com.webcuoiky.softwareshop.model.Software;
import com.webcuoiky.softwareshop.repository.SoftwareRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class SoftwaresController {

    @Autowired
    SessionFactory factory;

    @Autowired
    private SoftwareRepository repo;

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
        try{
            Software software = (Software) session.get(Software.class, id);
            model.addAttribute("software_detail", software);

            String category = software.getCategory();
            System.out.println("//////"+category);

            List<Software> softwareListRelated = repo.findByCategory(category);
            softwareListRelated.sort(Comparator.comparing(Software::getId).reversed());
            int limit = 4;
            if (softwareListRelated.size() > limit) {
                softwareListRelated = softwareListRelated.subList(0, limit);
            }
            model.addAttribute("softwareListRelated", softwareListRelated);

            return "software/software_detail";
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return "error";
        }
        finally{
            session.close();
        }
    }
}
