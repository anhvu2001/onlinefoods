<%-- 
    Document   : doanhThuTheoThang
    Created on : Oct 16, 2022, 1:12:28 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value ="/css/style.css"/>" />

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<h1 style="margin: 15px" class="text-center text-info">THỐNG KÊ BÁO CÁO DOANH THU SẢN PHẨM THEO THANG</h1>

<form action="">
    <div class="mb-3 mt-3">
        <label for="text" class="form-label">Từ khóa</label>
        <input type="text" class="form-control" placeholder="Nhập từ khóa" name="kw">
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Ngày bắt đầu</label>
        <input type="date" class="form-control" id="pwd" placeholder="Enter password" name="fromDate">
    </div>
    <div class="mb-3">
        <label for="pwd" class="form-label">Ngày kết thúc</label>
        <input type="date" class="form-control" id="pwd" placeholder="Enter password" name="toDate">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<div class="row">
    <div class="col-md-6 col-xs-12">
        <table class="table">
            <tr>
                <th>Tháng</th>
                <th>Doanh thu</th>
            </tr>
            <c:forEach items="${doanthusanphamthang}" var="c">
                <tr>
                    <td>${c[0]}/${c[1]}</td>
                    <td>${c[2]}</td>

                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6 col-xs-12">
        <canvas id="myChartdoanhthuThangSanpham"></canvas>
    </div>
</div>
<script src="<c:url value="/js/stats.js" />"></script>
<script>
    let sanphamLabels = [], sanphamData = [];
    <c:forEach items="${doanthusanphamthang}" var="c">
    sanphamData.push('${c[2]}');
    sanphamLabels.push('${c[0]}/${c[1]}');
    </c:forEach>
    window.onload = function () {
        doanthusanphamChart("myChartdoanhthuThangSanpham", sanphamLabels, sanphamData);
    }
</script>