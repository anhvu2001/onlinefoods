/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.ndav.pojos.Cart;
import com.ndav.pojos.User;
import com.ndav.service.OrderService;
import com.ndav.service.UserService;
import com.ndav.utils.Utils;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api")
public class ApiCartController {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private UserService userDetailsService;
    @Autowired
    private OrderService orderService;

    @PostMapping("/cart")
    public int addToCart(@RequestBody Cart params, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        int sanphamId = params.getSanphamId();
        if (cart.containsKey(sanphamId) == true) //san pham da có trong giỏ
        {
            Cart c = cart.get(sanphamId);
            c.setSoLuong(c.getSoLuong() + 1);
        } else {
            cart.put(sanphamId, params);
        }

        session.setAttribute("cart", cart);

        return Utils.countCart(cart);
    }

    @PutMapping("/cart")
    public ResponseEntity<Map<String, String>> updateCartItem(@RequestBody Cart params, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        int sanphamId = params.getSanphamId();
        if (cart.containsKey(sanphamId) == true) {
            Cart c = cart.get(sanphamId);
            c.setSoLuong(params.getSoLuong());
        }

        session.setAttribute("cart", cart);

        return new ResponseEntity<>(Utils.cartStats(cart), HttpStatus.OK);
    }

    @DeleteMapping("/cart/{sanphamId}")
    public ResponseEntity<Map<String, String>> deleteCartItem(@PathVariable(value = "sanphamId") int id, HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart != null && cart.containsKey(id)) {
            cart.remove(id);

            session.setAttribute("cart", cart);
        }

        return new ResponseEntity<>(Utils.cartStats(cart), HttpStatus.OK);
    }

    @PostMapping("/thanhtoan")
    public HttpStatus pay(@RequestBody Map<String, String> params, HttpSession session, Principal principal) {
        String diachi = params.get("diachi");
        String sdt = params.get("sodienthoai");
        String ghichu = params.get("ghichu");
        if (this.orderService.addReceipt((Map<Integer, Cart>) session.getAttribute("cart"), diachi, sdt, ghichu) == true) {
            User user = this.userDetailsService.getUserByUsername(principal.getName());
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(user.getEmail());
            message.setSubject("Xác nhận đã thanh toán");
            message.setText("Xin chào, bạn đã thanh toán thành công, cảm ơn bạn ủng hộ chúng tôi. Chúc bạn một ngày tốt lành.");
            this.emailSender.send(message);
            session.removeAttribute("cart");
            return HttpStatus.OK;

        }
        return HttpStatus.BAD_REQUEST;
    }

}
