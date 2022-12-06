/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.service.imlp;

import com.ndav.pojos.Loaisanpham;
import com.ndav.repository.LoaisanphamRepository;
import com.ndav.service.LoaisanphamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class LoaisanphamServiceImlp implements LoaisanphamService {
    @Autowired
    private LoaisanphamRepository loaisanphamRepository;

    @Override
    public List<Loaisanpham> getLoaisanpham() {
        return this.loaisanphamRepository.getLoaisanpham();
    }

}
