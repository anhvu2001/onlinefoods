/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndav.service;

import com.ndav.pojos.Cart;
import com.ndav.pojos.Donhang;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface OrderService {

    boolean addReceipt(Map<Integer, Cart> cart, String diachi, String sdt, String ghichu);

    List<Donhang> getDonhangByUser(int id);

}
