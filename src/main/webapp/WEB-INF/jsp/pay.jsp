<%-- 
    Document   : pay
    Created on : Sep 24, 2022, 12:11:32 PM
    Author     : ADMIN
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="<c:url value ="/css/style.css"/>" />


<c:if test="${carts == null}" >
    <h4 class="text-danger" style="padding: 10px">Chưa có sản phẩm nào!!! Hãy chọn món thêm vào ngay nhé.</h4>
</c:if>

<script src="<c:url value="/js/cart.js" />"></script>
<c:url value="/api/thanhtoan" var="t" />
<c:if test="${carts != null}" >   
    <form onsubmit="pay('${t}')" style="margin: 20px">
        <div class="form-outline mb-4">
            <input type="text" id="diachi" class="form-control"  required="required"/>
            <label class="form-label" for="form6Example4">Địa chỉ nhận hàng</label>
        </div>


        <!-- Number input -->
        <div class="form-outline mb-4">
            <input type="number" id="sodienthoai" class="form-control"  required="required"/>
            <label class="form-label" for="form6Example6">Số điện thoại</label>
        </div>

        <!-- Message input -->
        <div class="form-outline mb-4" >
            <textarea class="form-control" id="ghichu" rows="3"  required="required"></textarea>
            <label class="form-label" for="form6Example7">Ghi chú</label>
        </div>
        <div style="margin-bottom: 20px">
            <h4  class="text-danger"> <span style="color: #212529">Tổng số sản phẩm là: </span>${cartCounter}</h4>
            <h4 class="text-danger" id="amountCart"><span style="color: #212529">Tổng tiền: </span> <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${totalMoney}" /> VND</h4> 
        </div>

        <!-- Submit button -->
        <sec:authorize access="!isAuthenticated()">
            <strong>Vui lòng <a href="<c:url value="/login" />">Đăng nhập</a> để thanh toán!!!</strong>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <button type="submit" class="btn btn-warning btn-block btn-lg">Thanh toán</button>
        </sec:authorize>
    </form>
</c:if>
