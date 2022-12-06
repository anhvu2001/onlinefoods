/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.ndav.pojos.User;
import com.ndav.repository.OrderRepository;
import com.ndav.service.OrderService;
import com.ndav.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
@ControllerAdvice
public class UserController {

    @Autowired
    private UserService userDetailsService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/login")
    public String login(Model model) {

        return "login";
    }

    @RequestMapping("/thongtin")
    public String InfoUser(Model model, Principal principal) {
        User user = this.userDetailsService.getUserByUsername(principal.getName());
        int id = user.getId();
        model.addAttribute("thongtinnguoidung", this.userDetailsService.getUserByUsername(user.getUsername()));
        model.addAttribute("thongtindathang", this.orderService.getDonhangByUser(id));
        return "thongtinUser";
    }

    @GetMapping("/register")
    public String registerViews(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user) {
        String err = "";
        if (user.getPassword().equals(user.getConfirmPassWord()) || user.getPassword().isEmpty()) {
            if (this.userDetailsService.addUser(user) == true) {
                return "redirect:/login";
            } else {
                err = "da co loi xay ra";
            }

        } else {
            err = "Mật khẩu không khớp";
        }

        model.addAttribute("err", err);

        return "register";
    }
}
