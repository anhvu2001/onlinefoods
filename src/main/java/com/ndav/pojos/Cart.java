/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.pojos;

/**
 *
 * @author ADMIN
 */
public class Cart {

    private int sanphamId;
    private String tensanpham;
    private String anh;

    private long gia;
    private int soLuong;

    /**
     * @return the sanphamId
     */
    public int getSanphamId() {
        return sanphamId;
    }

    /**
     * @param sanphamId the sanphamId to set
     */
    public void setSanphamId(int sanphamId) {
        this.sanphamId = sanphamId;
    }

    /**
     * @return the tensanpham
     */
    public String getTensanpham() {
        return tensanpham;
    }

    /**
     * @param tensanpham the tensanpham to set
     */
    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    /**
     * @return the gia
     */
    public long getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(long gia) {
        this.gia = gia;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @return the anh
     */
    public String getAnh() {
        return anh;
    }

    /**
     * @param anh the anh to set
     */
    public void setAnh(String anh) {
        this.anh = anh;
    }

}
