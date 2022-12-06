
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<div class="mt-4 bg-light" style="padding: 15px;padding-left: 20px; margin-top: 1px !important;"  >
    <div id="header-content" class="pl-3" >
        <img
            src="${currentUser.avatar}"
            alt="avatar"
            class="rounded-circle img-fluid mb-3"
            style="max-width: 50px;"
            />

        <p><strong>Xin chào, <a href="<c:url value="/thongtin" />"  style="color:#f176ae;">${currentUser.username}</a>&nbsp;!</strong></p>

        <button type="button" class="btn btn-success dropdown-toggle" data-bs-toggle="dropdown" style="background-color: #FFC0C7; color: black">
            Quản lý
        </button>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item"  href="<c:url value="/admin/sanpham" />"  style="color: #FF69B4">Quản lý sản phẩm</a></li>
            <li><a class="dropdown-item" href="<c:url value="/admin/sanpham/anh" />" style="color: #FF69B4">Quản lý ảnh của sản phẩm </a></li>
            <li><a class="dropdown-item" href="<c:url value="/admin/stats" />" style="color: #FF69B4">Thống kê báo cáo </a></li>
            <li><a class="dropdown-item" href="<c:url value="/admin/doanhthusanpham" />" style="color: #FF69B4">Thống kê doanh thu sản phẩm</a></li>

        </ul>        
    </div>
</div>
