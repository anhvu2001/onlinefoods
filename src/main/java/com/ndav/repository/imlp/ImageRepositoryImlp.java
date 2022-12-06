/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.repository.imlp;

import com.ndav.pojos.Anhsanpham;
import com.ndav.repository.ImageRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class ImageRepositoryImlp implements ImageRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Anhsanpham> getListImage(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Anhsanpham> q = b.createQuery(Anhsanpham.class);
        Root root = q.from(Anhsanpham.class);
        q.select(root);
        q = q.where(b.equal(root.get("sanphamid"), id));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Anhsanpham getImageById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Anhsanpham.class, id);
    }

    @Override
    public boolean addImage(Anhsanpham anhsanpham) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(anhsanpham);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Anhsanpham> getListAllImage() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Anhsanpham");
        return q.getResultList();
    }

    @Override
    public boolean deleteAnhSanpham(int id) {
        {
            Session session = this.sessionFactory.getObject().getCurrentSession();

            try {
                Anhsanpham t = session.get(Anhsanpham.class, id);
                session.delete(t);
                return true;

            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }

        }
    }

}
