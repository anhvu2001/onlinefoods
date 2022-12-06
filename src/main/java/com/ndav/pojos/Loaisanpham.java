/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "loaisanpham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loaisanpham.findAll", query = "SELECT l FROM Loaisanpham l"),
    @NamedQuery(name = "Loaisanpham.findById", query = "SELECT l FROM Loaisanpham l WHERE l.id = :id"),
    @NamedQuery(name = "Loaisanpham.findByTenloaiSP", query = "SELECT l FROM Loaisanpham l WHERE l.tenloaiSP = :tenloaiSP"),
    @NamedQuery(name = "Loaisanpham.findByActive", query = "SELECT l FROM Loaisanpham l WHERE l.active = :active")})
public class Loaisanpham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tenloaiSP")
    private String tenloaiSP;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "loaisanpham")
    @JsonIgnore
    private Set<Sanpham> sanphamSet;

    public Loaisanpham() {
    }

    public Loaisanpham(Integer id) {
        this.id = id;
    }

    public Loaisanpham(Integer id, String tenloaiSP) {
        this.id = id;
        this.tenloaiSP = tenloaiSP;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenloaiSP() {
        return tenloaiSP;
    }

    public void setTenloaiSP(String tenloaiSP) {
        this.tenloaiSP = tenloaiSP;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Set<Sanpham> getSanphamSet() {
        return sanphamSet;
    }

    public void setSanphamSet(Set<Sanpham> sanphamSet) {
        this.sanphamSet = sanphamSet;
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
        if (!(object instanceof Loaisanpham)) {
            return false;
        }
        Loaisanpham other = (Loaisanpham) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndav.pojos.Loaisanpham[ id=" + id + " ]";
    }
    
}
