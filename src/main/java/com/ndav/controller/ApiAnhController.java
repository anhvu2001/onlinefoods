/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.ndav.pojos.Anhsanpham;
import com.ndav.service.ImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api")
public class ApiAnhController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/anhsanpham")
    public ResponseEntity<List<Anhsanpham>> list() {
        return new ResponseEntity<>(this.imageService.getListAllImage(), HttpStatus.OK);
    }

    @DeleteMapping("/anhsanpham/{anhsanphamId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSanpham(@PathVariable(value = "anhsanphamId") int id) {
        this.imageService.deleteAnhSanpham(id);
    }

}
