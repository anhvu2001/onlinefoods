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
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "anhsanpham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anhsanpham.findAll", query = "SELECT a FROM Anhsanpham a"),
    @NamedQuery(name = "Anhsanpham.findById", query = "SELECT a FROM Anhsanpham a WHERE a.id = :id"),
    @NamedQuery(name = "Anhsanpham.findByLinkanh", query = "SELECT a FROM Anhsanpham a WHERE a.linkanh = :linkanh")})
public class Anhsanpham implements Serializable {

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
    @Size(max = 255)
    @Column(name = "linkanh")
    private String linkanh;
    @JoinColumn(name = "sanphamid", referencedColumnName = "id")
    @ManyToOne
    private Sanpham sanphamid;
    @Transient
    private MultipartFile file;

    public Anhsanpham() {
    }

    public Anhsanpham(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkanh() {
        return linkanh;
    }

    public void setLinkanh(String linkanh) {
        this.linkanh = linkanh;
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
        if (!(object instanceof Anhsanpham)) {
            return false;
        }
        Anhsanpham other = (Anhsanpham) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ndav.pojos.Anhsanpham[ id=" + id + " ]";
    }

}
