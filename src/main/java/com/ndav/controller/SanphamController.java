/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;


import com.ndav.pojos.User;
import com.ndav.service.ImageService;
import com.ndav.service.SanphamService;
import com.ndav.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:messages.properties")
public class SanphamController {

    @Autowired
    private UserService userService;

    @Autowired
    private SanphamService sanphamService;

    @Autowired
    private ImageService imageService;

    @GetMapping("/sanpham/{sanphamId}")
    public String detail(Model model, @PathVariable(value = "sanphamId") int sanphamId, @PathVariable(value = "sanphamId") int iamgeSP) {
        model.addAttribute("sanpham", this.sanphamService.getSanphamById(sanphamId));
        model.addAttribute("imageid", this.imageService.getImageById(sanphamId));
        model.addAttribute("image", this.imageService.getListImage(iamgeSP));
        return "sanphamDetail";
    }

}
