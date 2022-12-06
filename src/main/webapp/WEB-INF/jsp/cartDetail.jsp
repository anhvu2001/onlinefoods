<%-- 
    Document   : cartDetail
    Created on : Sep 23, 2022, 2:25:37 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="<c:url value ="/css/style.css"/>" />
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>


<c:if test="${carts == null}" >
    <h4 class="text-danger" style="padding: 10px">Chưa có sản phẩm nào!!! Hãy chọn món thêm vào ngay nhé.</h4>
</c:if>

<c:url value="/api/cart" var="t" />
<script src="<c:url value="/js/cart.js" />"></script>
<c:if test="${carts != null}" >
    <section class="h-100" style="background-color:white; margin: 10px">
        <div class="container h-100 py-5">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-10">

                    <div class="d-flex justify-content-between align-items-center mb-4">
                        <h3 class="fw-normal mb-0 text-black">Giỏ hàng của bạn</h3>
                    </div>
                    <c:forEach items="${carts}" var="c">
                        <div class="card rounded-3 mb-4">
                            <div class="card-body p-4">
                                <div class="row d-flex justify-content-between align-items-center">
                                    <div class="col-md-2 col-lg-2 col-xl-2" style="max-width: 128px;max-height: 84px">
                                        <img 
                                            src="${c.anh}"
                                            class="img-fluid rounded-3" alt="anhsanpham" style="min-width: 128px;min-height: 84px;max-width: 128px;max-height: 84px">
                                    </div>
                                    <div class="col-md-3 col-lg-3 col-xl-3">
                                        <p class="lead fw-normal mb-2">${c.tensanpham}</p>
                                    </div>
                                    <div class="col-md-3 col-lg-3 col-xl-2 d-flex">

                                        <span  style="padding: 5px;padding-right: 10px">Số lượng</span>
                                        <input style="max-width:70px" id="form1" min="0" name="quantity" value="${c.soLuong}" type="number"
                                               class="form-control form-control-sm text-center" onblur="updateCart('${t}', this, ${c.sanphamId})" />


                                    </div>
                                    <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                        <h5 class="mb-0"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${c.gia}" /> VND</h5>
                                    </div>
                                    <div class="col-md-1 col-lg-1 col-xl-1 text-end" style="margin-right: 20px">
                                        <a href="" class="text-danger" onclick="deleteCartItem(${c.sanphamId})"><i class="fas fa-trash fa-lg"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <div class="d-flex" style="margin-bottom: 10px">
                        <h5 class = "text-danger" id="amountCart">Tổng tiền: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${totalMoney}" /> VND</h5> 

                    </div>
                    <a
                        class="btn btn-primary btn-floating m-1"
                        style="background-color: #008080;min-width: 120px;padding: 10px"
                        href="<c:url value="/thanhtoan" />"
                        role="button"
                        ><i class="fa-solid fa-cart-shopping"></i
                        > Đặt hàng</a>
                    <div style="padding: 30px;padding-left: 0px" >
                        <h6 class="mb-0"><a href="<c:url value="/" />" class="text-body" style="text-decoration: none"><i
                                    class="fas fa-long-arrow-alt-left me-2"></i>Back to shop</a></h6>
                    </div>

                </div>
            </div>
        </div>
    </section>
</c:if>
