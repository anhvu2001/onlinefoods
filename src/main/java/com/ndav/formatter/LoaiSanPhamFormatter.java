/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.formatter;

import com.ndav.pojos.Loaisanpham;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class LoaiSanPhamFormatter implements Formatter<Loaisanpham> {

    @Override
    public String print(Loaisanpham t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Loaisanpham parse(String id, Locale locale) throws ParseException {
        Loaisanpham c = new Loaisanpham();
        c.setId(Integer.parseInt(id));

        return c;
    }

}
