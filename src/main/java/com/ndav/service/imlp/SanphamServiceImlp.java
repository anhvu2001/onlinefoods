/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.service.imlp;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndav.pojos.Binhluan;
import com.ndav.pojos.Sanpham;
import com.ndav.repository.SanphamRepository;
import com.ndav.service.SanphamService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class SanphamServiceImlp implements SanphamService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private SanphamRepository sanphamRepository;

    @Override
    public List<Sanpham> getSanpham(Map<String, String> params, int page) {
        return this.sanphamRepository.getSanpham(params, page);
    }

    @Override
    public int countSanpham() {
        return this.sanphamRepository.countSanpham();
    }

    @Override
    public Sanpham getSanphamById(int id) {
        return this.sanphamRepository.getSanphamById(id);
    }

    @Override
    public boolean addOrUpdate(Sanpham sanpham) {
        try {
            Map r = this.cloudinary.uploader().upload(sanpham.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            sanpham.setAnh((String) r.get("secure_url"));
            return this.sanphamRepository.addOrUpdate(sanpham);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteSanpham(int id) {
        return this.sanphamRepository.deleteSanpham(id);
    }

    @Override
    public List<Binhluan> getComments(int sanphamId) {
        return this.sanphamRepository.getComments(sanphamId);
    }

    @Override
    public Binhluan addCommentSanpham(String content, int sanphamId) {
        return this.sanphamRepository.addCommentSanpham(content, sanphamId);
    }

    @Override
    public boolean deleteComment(int id) {
        return this.sanphamRepository.deleteComment(id);
    }

    @Override
    public List<Sanpham> getListSanpham() {
        return this.sanphamRepository.getListSanpham();
   }

    @Override
    public boolean editSanpham(Sanpham t, int id) {
         try {
            Map r = this.cloudinary.uploader().upload(t.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            t.setAnh((String) r.get("secure_url"));
            return this.sanphamRepository.editSanpham(t, id);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
