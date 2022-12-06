/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.ndav.pojos.Cart;
import com.ndav.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class CartController {

    //HttpSession bộ dữ liệu để nạp session
    @GetMapping("/cart-detail")
    public String gioHang(Model model, HttpSession session) {

        // kiem tra có giỏ hàng chưa
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart != null)// có giỏ rồi
        {
            model.addAttribute("carts", cart.values());// ds các item bỏ vô giỏ
        } else {
            model.addAttribute("carts", null);
        }

        model.addAttribute("totalMoney", Utils.sumAmount(cart));

        return "cartDetail";
    }

    @RequestMapping("/thanhtoan")
    public String thanhToan(Model model, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart != null)// có giỏ rồi
        {
            model.addAttribute("carts", cart.values());// ds các item bỏ vô giỏ
        } else {
            model.addAttribute("carts", null);
        }
        model.addAttribute("totalMoney", Utils.sumAmount(cart));

        return "pay";

    }
}
