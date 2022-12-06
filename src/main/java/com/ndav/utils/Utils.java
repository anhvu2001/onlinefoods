/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.utils;

import com.ndav.pojos.Cart;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public class Utils {

    public static int countCart(Map<Integer, Cart> cart) {
        int q = 0;

        if (cart != null) {
            for (Cart c : cart.values()) {
                q += c.getSoLuong();
            }
        }

        return q;
    }

    public static Map<String, String> cartStats(Map<Integer, Cart> cart) {
        Long s = 0l;
        int q = 0;

        if (cart != null) {
            for (Cart c : cart.values()) {
                q += c.getSoLuong();
                s += c.getSoLuong() * c.getGia();
            }
        }

        Map<String, String> kq = new HashMap<>();
        kq.put("counter", String.valueOf(q));
        kq.put("amount", String.valueOf(s));

        return kq;
    }
    public static long sumAmount(Map<Integer, Cart> cart){
        long s = 0;
         if (cart != null) {
            for (Cart c : cart.values()) {
                s += c.getSoLuong() * c.getGia();
            }
        }
         return s;
    }
}
