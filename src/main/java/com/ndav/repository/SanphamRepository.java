/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndav.repository;

import com.ndav.pojos.Binhluan;
import com.ndav.pojos.Sanpham;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ADMIN
 */
public interface SanphamRepository {

    List<Sanpham> getSanpham(Map<String, String> params, int page);

    List<Sanpham> getListSanpham();

    int countSanpham();

    Sanpham getSanphamById(int id);

    List<Binhluan> getComments(int sanphamId);

    Binhluan addCommentSanpham(String content, int sanphamId);

    boolean deleteComment(int id);

    boolean addOrUpdate(Sanpham sanpham);

    boolean deleteSanpham(int id);
    
    boolean editSanpham(Sanpham s , int id);

}
