/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.service.imlp;

import com.ndav.pojos.Cart;
import com.ndav.pojos.Donhang;
import com.ndav.repository.OrderRepository;
import com.ndav.service.OrderService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class OrderServiceImlp implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean addReceipt(Map<Integer, Cart> cart, String diachi, String sdt, String ghichu) {
        return this.orderRepository.addReceipt(cart, diachi, sdt, ghichu);
    }

    @Override
    public List<Donhang> getDonhangByUser(int id) {
        return this.orderRepository.getDonhangByUser(id);
    }
}
