/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.controller;

import com.ndav.pojos.Binhluan;
import com.ndav.service.SanphamService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api")
public class ApiCommentController {

    @Autowired
    private SanphamService sanphamService;

    @GetMapping("/sanpham/{sanphamId}/comments")
    public ResponseEntity<List<Binhluan>> getCommentsSp(@PathVariable(value = "sanphamId") int id) {

        return new ResponseEntity<>(this.sanphamService.getComments(id), HttpStatus.OK);
    }

    @PostMapping(path = "/sanpham/{sanphamId}/comments", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Binhluan> addCommentSanpham(@RequestBody Map<String, String> params, @PathVariable(value = "sanphamId") int id) {
        String content = params.get("content");

        Binhluan c = this.sanphamService.addCommentSanpham(content, id);

        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }

    @DeleteMapping("/sanpham/{sanphamId}/comments/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSanpham(@PathVariable(value = "commentId") int id) {
        this.sanphamService.deleteComment(id);
    }
}
