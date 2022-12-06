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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "binhluan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Binhluan.findAll", query = "SELECT b FROM Binhluan b"),
    @NamedQuery(name = "Binhluan.findById", query = "SELECT b FROM Binhluan b WHERE b.id = :id"),
    @NamedQuery(name = "Binhluan.findByNoidung", query = "SELECT b FROM Binhluan b WHERE b.noidung = :noidung"),
    @NamedQuery(name = "Binhluan.findByNgaybinhluan", query = "SELECT b FROM Binhluan b WHERE b.ngaybinhluan = :ngaybinhluan")})
public class Binhluan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "noidung")
    private String noidung;
    @Column(name = "ngaybinhluan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaybinhluan = new Date();
    @JoinColumn(name = "sanphamid", referencedColumnName = "id")
    @ManyToOne
    private Sanpham sanphamid;
    @JoinColumn(name = "nguoibinhluan", referencedColumnName = "id")
    @ManyToOne
    private User nguoibinhluan;

    public Binhluan() {
    }

    public Binhluan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public Date getNgaybinhluan() {
        return ngaybinhluan;
    }

    public void setNgaybinhluan(Date ngaybinhluan) {
        this.ngaybinhluan = ngaybinhluan;
    }

    public Sanpham getSanphamid() {
        return sanphamid;
    }

    public void setSanphamid(Sanpham sanphamid) {
        this.sanphamid = sanphamid;
    }

    public User getNguoibinhluan() {
        return nguoibinhluan;
    }

    public void setNguoibinhluan(User nguoibinhluan) {
        this.nguoibinhluan = nguoibinhluan;
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
        if (!(object instanceof Binhluan)) {
            return false;
        }
        Binhluan other = (Binhluan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndav.pojos.Binhluan[ id=" + id + " ]";
    }
    
}
