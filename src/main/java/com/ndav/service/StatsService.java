/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndav.service;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface StatsService {

    List<Object[]> countSanpham();

    List<Object[]> SanphamStats(String kw, Date fromDate, Date toDate);

    List<Object[]> SanphamStatsMonth(String kw, Date fromDate, Date toDate);

}
