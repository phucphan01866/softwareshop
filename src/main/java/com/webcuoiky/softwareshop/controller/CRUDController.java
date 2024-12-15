package com.webcuoiky.softwareshop.controller;

import com.webcuoiky.softwareshop.model.Software;
import com.webcuoiky.softwareshop.model.SoftwareDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.webcuoiky.softwareshop.services.SoftwareRepository;

import java.util.List;

@Controller
@RequestMapping("/admin/")
public class CRUDController {
//    @Autowired
//    SessionFactory factory;
//    @RequestMapping ("product-listt")
//    public String product_list(Model model)
//    {
//        return "adminPage/admin_product_list";
//    }
//
//    @RequestMapping("product-listt/product")
//    public String update_product(Model model)
//    {
//        return "adminPage/admin_product";
//    }
//
//    @ModelAttribute("softwares")
//    public List<Software> getSoftwares() {
//        Session session = factory.openSession();
//        String hql ="FROM Software";
//        Query query = session.createQuery(hql);
//        List<Software> list = query.list();
//        return list;
//    }

    @Autowired
    private SoftwareRepository repo;

    @GetMapping("product-list")
    public String showSoftwareList(Model model) {
        List<Software> softwareList = repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("softwares", softwareList);
        return "adminPage/admin_product_list";
    }

    @GetMapping("product-list/add-product")
    public String showCreatePage(Model model) {
        SoftwareDTO softwareDTO = new SoftwareDTO();
        model.addAttribute("softwareDTO", softwareDTO);
        return "adminPage/admin_add_product";
    }
    @PostMapping("product-list/add-product")
    public String createSoftware(@Valid @ModelAttribute SoftwareDTO softwareDTO, BindingResult result)
    {
        if (result.hasErrors()) {
            return "adminPage/admin_add_product";
        }

        Software software = new Software();
        software.setName(softwareDTO.getName());
        software.setDescription(softwareDTO.getDescription());
        software.setCategory(softwareDTO.getCategory());
        software.setPrice(softwareDTO.getPrice());
        software.setQuantity(softwareDTO.getQuantity());

        repo.save(software);
        return "redirect:/admin/product-list";
    }

    @GetMapping("product-list/update-product")
    public String showUpdatePage(Model model,
                                 @RequestParam int id)
    {
        try{
            Software software = repo.findById(id).get();
            model.addAttribute("softwareDTO", software);

            SoftwareDTO softwareDTO = new SoftwareDTO();
            softwareDTO.setName(software.getName());
            softwareDTO.setDescription(software.getDescription());
            softwareDTO.setCategory(software.getCategory());
            softwareDTO.setPrice(software.getPrice());
            softwareDTO.setQuantity(software.getQuantity());

            model.addAttribute("softwareDTO", softwareDTO);
        }
        catch (Exception ex){
            System.out.println("Exception" + ex.getMessage());
            return "adminPage/admin_product_list";
        }
        return "adminPage/admin_update_product";
    }

    @PostMapping("product-list/update-product")
    public String updateSoftware(@Valid @ModelAttribute SoftwareDTO softwareDTO,
                                 BindingResult result,
                                 Model model,
                                 @RequestParam int id){

        try{
            Software software = repo.findById(id).get();
            model.addAttribute("softwareDTO", softwareDTO);
            if(result.hasErrors()) {
                return "adminPage/admin_update_product";
            }

            software.setName(softwareDTO.getName());
            software.setDescription(softwareDTO.getDescription());
            software.setCategory(softwareDTO.getCategory());
            software.setPrice(softwareDTO.getPrice());
            software.setQuantity(softwareDTO.getQuantity());

            repo.save(software);

        }
        catch (Exception ex){
            System.out.println("Exception" + ex.getMessage());
        }

        return "redirect:/admin/product-list";
    }

    @GetMapping("product-list/delete")
    public String deleteProduct (
            @RequestParam int id
    ){
        try{
            Software software = repo.findById(id).get();
            repo.delete(software);
        }
        catch (Exception ex){
            System.out.println("Exception" + ex.getMessage());
        }
        return "redirect:/admin/product-list";  //chuyển hướng về admin/product-list
    }


}
