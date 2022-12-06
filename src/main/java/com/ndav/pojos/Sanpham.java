/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "sanpham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sanpham.findAll", query = "SELECT s FROM Sanpham s"),
    @NamedQuery(name = "Sanpham.findById", query = "SELECT s FROM Sanpham s WHERE s.id = :id"),
    @NamedQuery(name = "Sanpham.findByTensanpham", query = "SELECT s FROM Sanpham s WHERE s.tensanpham = :tensanpham"),
    @NamedQuery(name = "Sanpham.findByAnh", query = "SELECT s FROM Sanpham s WHERE s.anh = :anh"),
    @NamedQuery(name = "Sanpham.findByGiaSp", query = "SELECT s FROM Sanpham s WHERE s.giaSp = :giaSp"),
    @NamedQuery(name = "Sanpham.findByNgaytao", query = "SELECT s FROM Sanpham s WHERE s.ngaytao = :ngaytao"),
    @NamedQuery(name = "Sanpham.findByNgaycapnhat", query = "SELECT s FROM Sanpham s WHERE s.ngaycapnhat = :ngaycapnhat"),
    @NamedQuery(name = "Sanpham.findByActive", query = "SELECT s FROM Sanpham s WHERE s.active = :active"),
    @NamedQuery(name = "Sanpham.findByKhoiluong", query = "SELECT s FROM Sanpham s WHERE s.khoiluong = :khoiluong")})
public class Sanpham implements Serializable {

    /**
     * @param giaSp the giaSp to set
     */
    public void setGiaSp(Long giaSp) {
        this.giaSp = giaSp;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull    
    @Size(min = 1, max = 45)
    @Column(name = "tensanpham")
    private String tensanpham;
    @Size(max = 255)
    @Column(name = "anh")
    private String anh;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "mota")
    private String mota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "giaSp")
    private long giaSp;
    @Column(name = "ngaytao")
    @Temporal(TemporalType.DATE)
    private Date ngaytao = new Date();
    @Column(name = "ngaycapnhat")
    @Temporal(TemporalType.DATE)
    private Date ngaycapnhat;
    @Column(name = "active")
    private Boolean active = true;
    @Column(name = "khoiluong")
    private Integer khoiluong;
    @JoinColumn(name = "loaisanpham", referencedColumnName = "id")
    @ManyToOne
    private Loaisanpham loaisanpham;
    @Transient
    private MultipartFile file;

    public Sanpham() {
    }

    public Sanpham(Integer id) {
        this.id = id;
    }

    public Sanpham(Integer id, String tensanpham, long giaSp) {
        this.id = id;
        this.tensanpham = tensanpham;
        this.giaSp = giaSp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public long getGiaSp() {
        return giaSp;
    }

    public void setGiaSp(long giaSp) {
        this.setGiaSp((Long) giaSp);
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Date getNgaycapnhat() {
        return ngaycapnhat;
    }

    public void setNgaycapnhat(Date ngaycapnhat) {
        this.ngaycapnhat = ngaycapnhat;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getKhoiluong() {
        return khoiluong;
    }

    public void setKhoiluong(Integer khoiluong) {
        this.khoiluong = khoiluong;
    }

    public Loaisanpham getLoaisanpham() {
        return loaisanpham;
    }

    public void setLoaisanpham(Loaisanpham loaisanpham) {
        this.loaisanpham = loaisanpham;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sanpham)) {
            return false;
        }
        Sanpham other = (Sanpham) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndav.pojos.Sanpham[ id=" + id + " ]";
    }
    
}
