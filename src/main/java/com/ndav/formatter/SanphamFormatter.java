/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.formatter;

import com.ndav.pojos.Sanpham;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ADMIN
 */
public class SanphamFormatter implements Formatter<Sanpham> {

    @Override
    public String print(Sanpham t, Locale locale) {
        return String.valueOf(t.getId());
    }

    @Override
    public Sanpham parse(String id, Locale locale) throws ParseException {
        Sanpham c = new Sanpham();
        c.setId(Integer.parseInt(id));

        return c;
    }

}
