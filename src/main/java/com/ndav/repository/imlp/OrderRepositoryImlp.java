/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndav.repository.imlp;

import com.ndav.pojos.Cart;
import com.ndav.pojos.Chitietdh;
import com.ndav.pojos.Donhang;
import com.ndav.pojos.User;
import com.ndav.repository.OrderRepository;
import com.ndav.repository.SanphamRepository;
import com.ndav.repository.UserRepository;
import com.ndav.utils.Utils;
import java.util.Date;
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
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Repository
@Transactional
public class OrderRepositoryImlp implements OrderRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private SanphamRepository sanphamRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addReceipt(Map<Integer, Cart> cart, String diachi, String sdt, String ghichu) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            Donhang orders = new Donhang();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            orders.setNguoiDH(this.userRepository.getUserByUsername(authentication.getName()));
            orders.setNgaytao(new Date());
            orders.setDiachi(diachi);
            orders.setTrangthaiDH(Boolean.TRUE);
            orders.setSodienthoai(sdt);
            orders.setGhichu(ghichu);

            Map<String, String> totalMoney = Utils.cartStats(cart);
            orders.setTongtienDH(Long.parseLong(totalMoney.get("amount")));

            session.save(orders);

            for (Cart c : cart.values()) {
                Chitietdh orderDetail = new Chitietdh();
                orderDetail.setDonhangid(orders);

                orderDetail.setSanphamid(this.sanphamRepository.getSanphamById(c.getSanphamId()));
                orderDetail.setTongtienSp(c.getSoLuong() * c.getGia());
                orderDetail.setSoluong(c.getSoLuong());

                session.save(orderDetail);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Donhang> getDonhangByUser(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Donhang> q = b.createQuery(Donhang.class);
        Root root = q.from(Donhang.class);
        q.select(root);
        q = q.where(b.equal(root.get("nguoiDH"), id));
        Query query = session.createQuery(q);
        return query.getResultList();
    }

}
