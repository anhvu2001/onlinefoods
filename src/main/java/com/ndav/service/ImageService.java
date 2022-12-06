/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndav.service;

import com.ndav.pojos.Anhsanpham;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface ImageService {

    List<Anhsanpham> getListImage(int id);

    Anhsanpham getImageById(int id);

    boolean addImage(Anhsanpham anhsanpham);

    List<Anhsanpham> getListAllImage();

    boolean deleteAnhSanpham(int id);

}
