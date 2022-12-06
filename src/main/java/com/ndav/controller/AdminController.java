/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndav.pojos.Anhsanpham;
import com.ndav.pojos.Sanpham;
import com.ndav.service.ImageService;
import com.ndav.service.SanphamService;
import com.ndav.service.StatsService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMIN
 */
@Controller
@PropertySource("classpath:messages.properties")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SanphamService sanphamService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private StatsService statsService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/sanpham")
    public String manageSanpham(Model model) {
        model.addAttribute("sanpham", new Sanpham());
        return "adminSanpham";
    }

    @PostMapping("/sanpham")
    public String add(@ModelAttribute(value = "sanpham") @Valid Sanpham s,
            BindingResult r) {
        if (r.hasErrors()) {
            return "adminSanpham";
        }

        if (this.sanphamService.addOrUpdate(s) == true) {
            return "redirect:/";
        }

        return "adminSanpham";
    }

    @GetMapping("/sanpham/anh")
    public String manageAnhSanpham(Model model) {
        model.addAttribute("anhsanpham", new Anhsanpham());
        return "adminAnhsanpham";
    }

    @PostMapping("/sanpham/anh")
    public String addanh(@ModelAttribute(value = "anhsanpham") @Valid Anhsanpham s,
            BindingResult r) {
        if (r.hasErrors()) {
            return "adminAnhsanpham";
        }

        if (this.imageService.addImage(s) == true) {
            return "redirect:/";
        }

        return "adminAnhsanpham";
    }

    @GetMapping("/stats")
    public String stats(Model model) {
        model.addAttribute("sanphamStats", this.statsService.countSanpham());
        return "stats";
    }

    @GetMapping("/doanhthusanpham")
    public String Sanphamstats(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        Date fromDate = null;
        Date toDate = null;
        String from = params.getOrDefault("fromDate", null);
        try {
            if (from != null) {
                fromDate = f.parse(from);
            }
            String to = params.getOrDefault("toDate", null);
            if (from != null) {
                toDate = f.parse(to);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("doanthusanpham", this.statsService.SanphamStats(kw, fromDate, toDate));
        return "doanhThuSanPhamstats";
    }
     @GetMapping("/doanhthusanphamthang")
    public String SanphamstatsMonth(Model model, @RequestParam(required = false) Map<String, String> params) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        Date fromDate = null;
        Date toDate = null;
        String from = params.getOrDefault("fromDate", null);
        try {
            if (from != null) {
                fromDate = f.parse(from);
            }
            String to = params.getOrDefault("toDate", null);
            if (from != null) {
                toDate = f.parse(to);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("doanthusanphamthang", this.statsService.SanphamStatsMonth(kw, fromDate, toDate));
        return "doanhThuTheoThang";
    }

    @GetMapping("/sanpham/{sanphamId}")
    public String list(Model model, @PathVariable(value = "sanphamId") int id) {
        model.addAttribute("sanphamEdit", new Sanpham());
        model.addAttribute("editSanpham", this.sanphamService.getSanphamById(id));

        return "adminEditSanpham";
    }

    @PostMapping("/sanpham/{sanphamId}")
    public String edit(Model model, @PathVariable(value = "sanphamId") int id,
            @ModelAttribute(value = "sanphamEdit") @Valid Sanpham sanpham, BindingResult rs) {
        if (!rs.hasErrors()) {
            if (this.sanphamService.editSanpham(sanpham, id) == true) {
                return "redirect:/admin/sanpham";
            }
        }

        return "adminEditSanpham";
    }

}
