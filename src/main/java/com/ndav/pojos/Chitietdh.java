/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.pojos;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "chitietdh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chitietdh.findAll", query = "SELECT c FROM Chitietdh c"),
    @NamedQuery(name = "Chitietdh.findById", query = "SELECT c FROM Chitietdh c WHERE c.id = :id"),
    @NamedQuery(name = "Chitietdh.findBySoluong", query = "SELECT c FROM Chitietdh c WHERE c.soluong = :soluong"),
    @NamedQuery(name = "Chitietdh.findByTongtienSp", query = "SELECT c FROM Chitietdh c WHERE c.tongtienSp = :tongtienSp"),
    @NamedQuery(name = "Chitietdh.findByActive", query = "SELECT c FROM Chitietdh c WHERE c.active = :active")})
public class Chitietdh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "soluong")
    private Integer soluong;
    @Column(name = "tongtienSp")
    private Long tongtienSp;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "donhangid", referencedColumnName = "id")
    @ManyToOne
    private Donhang donhangid;
    @JoinColumn(name = "sanphamid", referencedColumnName = "id")
    @ManyToOne
    private Sanpham sanphamid;

    public Chitietdh() {
    }

    public Chitietdh(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Long getTongtienSp() {
        return tongtienSp;
    }

    public void setTongtienSp(Long tongtienSp) {
        this.tongtienSp = tongtienSp;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Donhang getDonhangid() {
        return donhangid;
    }

    public void setDonhangid(Donhang donhangid) {
        this.donhangid = donhangid;
    }

    public Sanpham getSanphamid() {
        return sanphamid;
    }

    public void setSanphamid(Sanpham sanphamid) {
        this.sanphamid = sanphamid;
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
        if (!(object instanceof Chitietdh)) {
            return false;
        }
        Chitietdh other = (Chitietdh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndav.pojos.Chitietdh[ id=" + id + " ]";
    }
    
}
