<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="<c:url value ="/css/style.css"/>" />



<section class="signup page_customer_account">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-main-acount">
                <div id="parent" class="row">
                    <div id="a" class="col-xs-12 col-sm-12 col-lg-9 col-left-account" style="margin-top: 20px">

                        <div class="col-xs-12 col-sm-12 col-lg-12 no-padding">
                            <div class="my-account">
                                <div class="dashboard">

                                    <div class="recent-orders">
                                        <div class="table-responsive tab-all"style="overflow-x:auto;">
                                            <table class="table table-cart" id="my-orders-table">
                                                <thead class="thead-default">
                                                    <tr>
                                                        <th>Mã đơn hàng</th>
                                                        <th>Ngày đặt hàng</th>
                                                        <th>Địa chỉ người nhận</th>
                                                        <th>Giá trị đơn hàng</th>
                                                        <th>Tình trạng thanh toán</th>
                                                    </tr>
                                                </thead>

                                                <tbody >
                                                    <c:forEach items="${thongtindathang}" var="c">
                                                        <tr>
                                                            <td>${c.id}</td>
                                                            <td>${c.ngaytao}</td>
                                                            <td>${c.diachi}</td>
                                                            <td><p><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${c.tongtienDH}" /> VND</p> 
                                                            </td>
                                                            <c:if test="${c.trangthaiDH == false}">
                                                                <td class="text-danger">Chưa thanh toán</td>
                                                            </c:if>
                                                            <c:if test="${c.trangthaiDH == true}">
                                                                <td>Đã thanh toán</td>
                                                            </c:if>

                                                        </tr>
                                                    </c:forEach>
                                                </tbody>


                                            </table>

                                        </div>

                                        <div class="text-xs-right">

                                        </div>
                                    </div>
                                    <div class="paginate-pages pull-right page-account">
                                        <ul class="pagination pagination-blog">
                                        </ul>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div id="b" class="col-xs-12 col-sm-12 col-lg-3 col-right-account">
                        <div class="page-title mx991">
                            <h3 class="title-head">Thông tin tài khoản</h3>
                        </div>
                        <div class="form-signup body_right mx991"> 
                            <p><strong>Xin chào, <a href="#" style="color:#f176ae;">${currentUser.username}</a>&nbsp;!</strong></p>
                        </div>
                        <div class="block-account">
                            <div class="block-title-account"><h5>Tài khoản của tôi</h5></div>
                            <div class="block-content form-signup">
                                <p>Tên tài khoản: <strong style="line-height: 20px;">${currentUser.username}</strong></p>
                                <p><i class="fa fa-home font-some" aria-hidden="true"></i>  <span>Địa chỉ: ${thongtinnguoidung.diachi} </span></p>
                                <p><i class="fa fa-mobile font-some" aria-hidden="true"></i> <span>Điện thoại: ${thongtinnguoidung.sodienthoai} </span> </p>
                                <p><i class="fa-regular fa-envelope font-some" aria-hidden="true"></i> <span> Email: ${thongtinnguoidung.email} </span></p>
                                <p><i class="fa fa-yelp font-some" aria-hidden="true"></i> <span> Công ty: </span></p>
                                <p><i class="fa fa-plane font-some" aria-hidden="true"></i> <span> Quốc gia : Việt Nam</span></p> 
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>

