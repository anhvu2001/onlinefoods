<%-- 
    Document   : index
    Created on : Jul 22, 2022, 4:03:18 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="stylesheet" href="<c:url value ="/css/style.css"/>" />


<div style="padding-top:10px;" class="stylephantrang">
    <ul class="pagination" style="margin:0px">
        <c:forEach begin="1" end="${Math.ceil(Countsanpham/pageSize)}" var="i">
            <c:url value="/" var="t">
                <c:param name="page" value="${i}" />
            </c:url>
            <li class="page-item"><a class="page-link" href="${t}">${i}</a></li>
            </c:forEach>
    </ul>
</div>

<div class="row" >
    <c:forEach items="${listsanpham}" var="t">
        <div class="col-md-3 col-xs-12" style="margin-top: 25px" >
            <div class="card" style="width:300px;min-height: 400px;border: 0.3rem solid #e1f7f7;">
                <img class="card-img-top" src="${t.anh}" alt="Card image" style="min-height: 240px;max-height: 240px" >
                <div class="card-body" >
                    <h4  class="text-black text-center"  >${t.tensanpham}</h4>
                    <p class="text-danger"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${t.giaSp}" /> VND</p>
                    <p class="card-text">Khối lượng: ${t.khoiluong} gam</p>
                    <a href="<c:url value="/sanpham/${t.id}" />" class="btn btn btn-info" style="margin-left: 75px">Xem Chi Tiết</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
