package com.webcuoiky.softwareshop.controller;

import com.webcuoiky.softwareshop.model.Order_items;
import com.webcuoiky.softwareshop.model.Software;

import com.webcuoiky.softwareshop.repository.SoftwareRepository;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {

    @Autowired
    private SoftwareRepository softwareRepository;

    @PostMapping("softwares/addToCart")
    public String addToCart(@RequestParam("id") Integer id,
                            @RequestParam("name") String name,
                            @RequestParam("image") String image,
                            @RequestParam("price") Float price,
                            @RequestParam(value = "sale_price", required = false) Float sale_price,
                            @RequestParam("quantity") Integer quantity,
                            HttpSession session,
                            Model model) {

        Map<Integer, Order_items> cart = (Map<Integer, Order_items>) session.getAttribute("cart");

        if(cart == null) {
            cart = new HashMap<>();
        }

        Float priceToCharge = sale_price != null ? sale_price : price;

        if (cart.containsKey(id)) {
            Order_items existingItem = cart.get(id);
            existingItem.getSoftware().setQuantity(existingItem.getSoftware().getQuantity() + quantity);
        } else {
            Order_items newItem = new Order_items();
            Software newSoftware = new Software();
            newSoftware.setId(id);
            newSoftware.setName(name);
            newSoftware.setImage(image);
            newSoftware.setPrice(priceToCharge);
            newSoftware.setSale_price(sale_price);
            newSoftware.setQuantity(quantity);
            newItem.setSoftware(newSoftware);
            cart.put(id, newItem);
        }

        double subtotal = calculateTotal(cart);
        int totalQuantity = calculateTotalQuantity(cart);

        session.setAttribute("cart", cart);

        model.addAttribute("cart", cart.values());
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("totalQuantity", totalQuantity);

        List<Software> softwares = softwareRepository.findAll();
        model.addAttribute("softwares", softwares);

        return "redirect:/softwares";
    }

    public double calculateTotal(Map<Integer, Order_items> orderItems) {
        double total = 0.0;
        if (orderItems != null) {
            for (Order_items item : orderItems.values()) {
                if (item.getSoftware() != null) {
                    total += item.getSoftware().getPrice() * item.getSoftware().getQuantity();
                }
            }
        }
        return total;
    }

    public int calculateTotalQuantity(Map<Integer, Order_items> cart) {
        int totalQuantity = 0;
        for (Order_items item : cart.values()) {
            totalQuantity += item.getSoftware().getQuantity();
        }
        return totalQuantity;
    }


    @PostMapping("softwares/removeFromCart")
    public String removeFromCart(@RequestParam("id") Integer id, HttpSession session, Model model) {

        Map<Integer, Order_items> cart = (Map<Integer, Order_items>) session.getAttribute("cart");

        if (cart != null && cart.containsKey(id)) {
            cart.remove(id);
            session.setAttribute("cart", cart);

            double subtotal = calculateTotal(cart);
            int totalQuantity = calculateTotalQuantity(cart);

            model.addAttribute("cart", cart.values());
            model.addAttribute("subtotal", subtotal);
            model.addAttribute("totalQuantity", totalQuantity);
        }

        List<Software> softwares = softwareRepository.findAll();
        model.addAttribute("softwares", softwares);

        return "software/softwares";
    }

    @RequestMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        Map<Integer, Order_items> cart = (Map<Integer, Order_items>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            return "redirect:/";
        }

        double subtotal = calculateTotal(cart);
        int totalQuantity = calculateTotalQuantity(cart);

        model.addAttribute("cart", cart.values());
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("totalQuantity", totalQuantity);

        return "software/checkout";
    }

    @RequestMapping("/thankyou")
    public String thankyou() {
        return "software/thankyou";
    }
}
