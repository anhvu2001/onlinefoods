/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.service.imlp;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndav.pojos.Anhsanpham;
import com.ndav.repository.ImageRepository;
import com.ndav.service.ImageService;
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
public class ImageServiceImlp implements ImageService {

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Anhsanpham getImageById(int id) {
        return this.imageRepository.getImageById(id);
    }

    @Override
    public List<Anhsanpham> getListImage(int id) {
        return this.imageRepository.getListImage(id);
    }

    @Override
    public boolean addImage(Anhsanpham anhsanpham) {
        try {
            Map r = this.cloudinary.uploader().upload(anhsanpham.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            anhsanpham.setLinkanh((String) r.get("secure_url"));
            return this.imageRepository.addImage(anhsanpham);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Anhsanpham> getListAllImage() {
        return this.imageRepository.getListAllImage();
    }

    @Override
    public boolean deleteAnhSanpham(int id) {
        return this.imageRepository.deleteAnhSanpham(id);
    }

}
