/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.repository.imlp;

import com.ndav.pojos.Binhluan;
import com.ndav.pojos.Sanpham;
import com.ndav.pojos.User;
import com.ndav.repository.SanphamRepository;
import com.ndav.repository.UserRepository;
import com.ndav.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@PropertySource("classpath:messages.properties")
@Transactional
public class SanphamRepositoryImlp implements SanphamRepository {

    @Autowired
    private UserService userService;

    @Autowired
    private Environment env;

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Sanpham> getSanpham(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Sanpham> q = b.createQuery(Sanpham.class);
        Root root = q.from(Sanpham.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("tensanpham").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }

            String loaisanphamid = params.get("loaisanphamid");
            if (loaisanphamid != null) {
                Predicate p = b.equal(root.get("loaisanpham"), Integer.parseInt(loaisanphamid));
                predicates.add(p);
            }
            String fp = params.get("fromPrice");
            if (fp != null) {
                Predicate p = b.greaterThanOrEqualTo(root.get("giaSp").as(Long.class), Long.parseLong(fp));
                predicates.add(p);
            }

            String tp = params.get("toPrice");
            if (tp != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("giaSp").as(Long.class), Long.parseLong(tp));
                predicates.add(p);
            }

            q.where(predicates.toArray(new Predicate[]{}));

        }

        q.orderBy(b.desc(root.get("id")), b.desc(root.get("tensanpham")));

        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public int countSanpham() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        org.hibernate.query.Query q = session.createQuery("SELECT Count(*) FROM Sanpham");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public Sanpham getSanphamById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Sanpham.class, id);
    }

    @Override
    public boolean deleteSanpham(int id) {
        {
            Session session = this.sessionFactory.getObject().getCurrentSession();

            try {
                Sanpham t = session.get(Sanpham.class, id);
                session.delete(t);
                return true;

            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }

        }
    }

    @Override
    public boolean addOrUpdate(Sanpham sanpham) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(sanpham);

            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Binhluan> getComments(int sanphamId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Binhluan> q = b.createQuery(Binhluan.class);
        Root root = q.from(Binhluan.class);
        q.select(root);

        q.where(b.equal(root.get("sanphamid"), sanphamId));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Binhluan addCommentSanpham(String content, int sanphamId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Binhluan c = new Binhluan();
        c.setNoidung(content);
        c.setSanphamid(this.getSanphamById(sanphamId));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = this.userService.getUserByUsername(authentication.getName());
        c.setNguoibinhluan(this.userRepository.getUserByUsername(authentication.getName()));
//        c.setUserid(user);
        session.save(c);

        return c;
    }

    @Override
    public boolean deleteComment(int id) {
        {
            Session session = this.sessionFactory.getObject().getCurrentSession();

            try {
                Binhluan t = session.get(Binhluan.class, id);
                session.delete(t);
                return true;

            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }

        }
    }

    @Override
    public List<Sanpham> getListSanpham() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Sanpham");
        return q.getResultList();
    }

    @Override
    public boolean editSanpham(Sanpham t, int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        try {
            Sanpham p = session.get(Sanpham.class, id);
            p.setTensanpham(t.getTensanpham());
            p.setKhoiluong(t.getKhoiluong());
            p.setAnh(t.getAnh());
            p.setGiaSp(t.getGiaSp());
            p.setLoaisanpham(t.getLoaisanpham());
            p.setMota(t.getMota());
            
            session.save(p);
            
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
