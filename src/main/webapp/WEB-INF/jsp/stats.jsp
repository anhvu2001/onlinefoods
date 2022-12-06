<%-- 
    Document   : stats
    Created on : Sep 5, 2022, 11:05:43 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<c:url value ="/css/style.css"/>" />

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script src="<c:url value="/js/stats.js" />"></script>
<h1 style="margin: 15px" class="text-center text-info">THỐNG KÊ BÁO CÁO</h1>

<div class="row">
    <div class="col-md-6 col-xs-12">
        <table class="table">
            <tr>
                <th>Id</th>
                <th>Loại sản phẩm</th>
                <th>Số sản phẩm</th>
            </tr>
            <c:forEach items="${sanphamStats}" var="c">
                <tr>
                    <td>${c[0]}</td>
                    <td>${c[1]}</td>
                    <td>${c[2]}</td>

                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6 col-xs-12">
        <canvas id="myChartSanpham"></canvas>
    </div>
</div>



<script src="<c:url value="/js/stats.js" />"></script>
<script>
    let cateLabels = [], cateData = [];
    <c:forEach items="${sanphamStats}" var="c">
    cateData.push(${c[2]});
    cateLabels.push('${c[1]}');
    </c:forEach>
    window.onload = function () {
        sanphamStats("myChartSanpham", cateLabels, cateData);
    }
</script>

