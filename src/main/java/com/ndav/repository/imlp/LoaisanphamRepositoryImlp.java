/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.repository.imlp;

import com.ndav.pojos.Loaisanpham;
import com.ndav.repository.LoaisanphamRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class LoaisanphamRepositoryImlp implements LoaisanphamRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Loaisanpham> getLoaisanpham() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Loaisanpham");
        return q.getResultList();
    }

}
