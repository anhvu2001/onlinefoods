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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "donhang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donhang.findAll", query = "SELECT d FROM Donhang d"),
    @NamedQuery(name = "Donhang.findById", query = "SELECT d FROM Donhang d WHERE d.id = :id"),
    @NamedQuery(name = "Donhang.findByTongtienDH", query = "SELECT d FROM Donhang d WHERE d.tongtienDH = :tongtienDH"),
    @NamedQuery(name = "Donhang.findByNgaytao", query = "SELECT d FROM Donhang d WHERE d.ngaytao = :ngaytao"),
    @NamedQuery(name = "Donhang.findByTrangthaiDH", query = "SELECT d FROM Donhang d WHERE d.trangthaiDH = :trangthaiDH"),
    @NamedQuery(name = "Donhang.findBySodienthoai", query = "SELECT d FROM Donhang d WHERE d.sodienthoai = :sodienthoai"),
    @NamedQuery(name = "Donhang.findByDiachi", query = "SELECT d FROM Donhang d WHERE d.diachi = :diachi"),
    @NamedQuery(name = "Donhang.findByGhichu", query = "SELECT d FROM Donhang d WHERE d.ghichu = :ghichu")})
public class Donhang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tongtienDH")
    private long tongtienDH;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaytao")
    @Temporal(TemporalType.DATE)
    private Date ngaytao = new Date();
    @Column(name = "trangthaiDH")
    private Boolean trangthaiDH;
    @Size(max = 15)
    @Column(name = "sodienthoai")
    private String sodienthoai;
    @Size(max = 200)
    @Column(name = "diachi")
    private String diachi;
    @Size(max = 255)
    @Column(name = "ghichu")
    private String ghichu;
    @JoinColumn(name = "nguoiDH", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User nguoiDH;

    public Donhang() {
    }

    public Donhang(Integer id) {
        this.id = id;
    }

    public Donhang(Integer id, long tongtienDH, Date ngaytao) {
        this.id = id;
        this.tongtienDH = tongtienDH;
        this.ngaytao = ngaytao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getTongtienDH() {
        return tongtienDH;
    }

    public void setTongtienDH(long tongtienDH) {
        this.tongtienDH = tongtienDH;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Boolean getTrangthaiDH() {
        return trangthaiDH;
    }

    public void setTrangthaiDH(Boolean trangthaiDH) {
        this.trangthaiDH = trangthaiDH;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public User getNguoiDH() {
        return nguoiDH;
    }

    public void setNguoiDH(User nguoiDH) {
        this.nguoiDH = nguoiDH;
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
        if (!(object instanceof Donhang)) {
            return false;
        }
        Donhang other = (Donhang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndav.pojos.Donhang[ id=" + id + " ]";
    }
    
}
