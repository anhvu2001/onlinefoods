/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.repository.imlp;

import com.ndav.pojos.Chitietdh;
import com.ndav.pojos.Donhang;
import com.ndav.pojos.Loaisanpham;
import com.ndav.pojos.Sanpham;
import com.ndav.repository.StatsRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@PropertySource("classpath:messages.properties")
@Transactional
public class StatsRepositoryImlp implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> countSanpham() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rT = q.from(Sanpham.class);
        Root rTy = q.from(Loaisanpham.class);

        q.where(b.equal(rT.get("loaisanpham"), rTy.get("id")));
        q.multiselect(rTy.get("id"), rTy.get("tenloaiSP"), b.count(rT.get("id")));
        q.groupBy(rTy.get("id"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> SanphamStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rS = q.from(Sanpham.class);
        Root rO = q.from(Donhang.class);
        Root rD = q.from(Chitietdh.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rD.get("sanphamid"), rS.get("id")));
        predicates.add(b.equal(rD.get("donhangid"), rO.get("id")));
        q.multiselect(rS.get("id"), rS.get("tensanpham"), rD.get("tongtienSp"));
        q.groupBy(rS.get("id"));
        
        q.where(predicates.toArray(new Predicate[] {}));
        
        if(kw != null && !kw.isEmpty()){
            predicates.add(b.like(rS.get("tensanpham"), String.format("%%%s%%", kw)));
        }
        if(fromDate != null){
            predicates.add(b.greaterThanOrEqualTo(rO.get("ngaytao"), fromDate));
        }
        if(toDate != null){
            predicates.add(b.lessThanOrEqualTo(rO.get("ngaytao"), toDate));
        }
        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(rS.get("id"));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> SanphamStatsMonth(String kw, Date fromDate, Date toDate) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rS = q.from(Sanpham.class);
        Root rO = q.from(Donhang.class);
        Root rD = q.from(Chitietdh.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rD.get("sanphamid"), rS.get("id")));
        predicates.add(b.equal(rD.get("donhangid"), rO.get("id")));
         q.multiselect(b.function("MONTH", Integer.class, rO.get("ngaytao")),
                b.function("YEAR", Integer.class, rO.get("ngaytao")), rD.get("tongtienSp"));
        
        q.where(predicates.toArray(new Predicate[] {}));
        
        if(kw != null && !kw.isEmpty()){
            predicates.add(b.like(rS.get("tensanpham"), String.format("%%%s%%", kw)));
        }
        if(fromDate != null){
            predicates.add(b.greaterThanOrEqualTo(rO.get("ngaytao"), fromDate));
        }
        if(toDate != null){
            predicates.add(b.lessThanOrEqualTo(rO.get("ngaytao"), toDate));
        }
        q.where(predicates.toArray(new Predicate[]{}));
        q.groupBy(b.function("MONTH", Integer.class, rO.get("ngaytao")),
                b.function("YEAR", Integer.class, rO.get("ngaytao")));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

}

// public List<Object[]> sanPhamStats(String kw, Date fromDate, Date toDate) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//
//        Root rootS = q.from(SanPham.class);
//        Root rootO = q.from(SaleOrder.class);
//        Root rootD = q.from(OrderDetail.class);
//
//        List<Predicate> predicates = new ArrayList<>();
//        predicates.add(b.equal(rootD.get("sanPham"), rootS.get("id")));
//        predicates.add(b.equal(rootD.get("orderId"), rootO.get("id")));
//
//        q.multiselect(rootS.get("id"), rootS.get("ten"),
//                b.sum(b.prod(rootD.get("unitPrice"), rootD.get("num"))));
//
//        if (kw != null && !kw.isEmpty()) {
//            predicates.add(b.like(rootS.get("ten"), String.format("%%%s%%", kw)));
//        }
//        if (fromDate != null) {
//            predicates.add(b.greaterThanOrEqualTo(rootO.get("ngayTao"), fromDate));
//        }
//        if (toDate != null) {
//            predicates.add(b.lessThanOrEqualTo(rootO.get("ngayTao"), toDate));
//        }
//
//        q.where(predicates.toArray(new Predicate[]{}));
//        q.groupBy(rootS.get("id"));
//
//        Query query = session.createQuery(q);
//        return query.getResultList();
//    }
//
//    @Override
//    public List<Object[]> sanPhamThangStats(String kw, Date fromDate, Date toDate) {
//        Session session = this.sessionFactory.getObject().getCurrentSession();
//
//        CriteriaBuilder b = session.getCriteriaBuilder();
//        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//
//        Root rootS = q.from(SanPham.class);
//        Root rootO = q.from(SaleOrder.class);
//        Root rootD = q.from(OrderDetail.class);
//
//        List<Predicate> predicates = new ArrayList<>();
//        predicates.add(b.equal(rootD.get("sanPham"), rootS.get("id")));
//        predicates.add(b.equal(rootD.get("orderId"), rootO.get("id")));
//
//        q.multiselect(b.function("MONTH", Integer.class, rootO.get("ngayTao")),
//                b.function("YEAR", Integer.class, rootO.get("ngayTao")),
//                b.sum(b.prod(rootD.get("unitPrice"), rootD.get("num"))));
//
//        if (kw != null && !kw.isEmpty()) {
//            predicates.add(b.like(rootS.get("ten"), String.format("%%%s%%", kw)));
//        }
//        if (fromDate != null) {
//            predicates.add(b.greaterThanOrEqualTo(rootO.get("ngayTao"), fromDate));
//        }
//        if (toDate != null) {
//            predicates.add(b.lessThanOrEqualTo(rootO.get("ngayTao"), toDate));
//        }
//
//        q.where(predicates.toArray(new Predicate[]{}));
//        q.groupBy(b.function("MONTH", Integer.class, rootO.get("ngayTao")),
//                b.function("YEAR", Integer.class, rootO.get("ngayTao")));
//
//        Query query = session.createQuery(q);
//        return query.getResultList();
//    }
//
//}
