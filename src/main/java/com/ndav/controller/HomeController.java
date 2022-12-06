/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.ndav.pojos.Cart;
import com.ndav.service.ImageService;
import com.ndav.service.LoaisanphamService;
import com.ndav.service.SanphamService;
import com.ndav.utils.Utils;
import javax.persistence.Query;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:messages.properties")
public class HomeController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private Environment env;

    @Autowired
    private SanphamService sanphamService;

    @Autowired
    private LoaisanphamService loaisanphamService;

    @ModelAttribute
    public void commonAttr(Model model, HttpSession session) {
        model.addAttribute("listloaisanpham", this.loaisanphamService.getLoaisanpham());
        model.addAttribute("listAllsanpham", this.sanphamService.getListSanpham());
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("cartCounter", Utils.countCart((Map<Integer, Cart>) session.getAttribute("cart")));

    }

    @RequestMapping("/")
    public String Home(Model model, @RequestParam Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("Countsanpham", this.sanphamService.countSanpham());
        model.addAttribute("listsanpham", this.sanphamService.getSanpham(params, page));
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));

        return "index";
    }
}
