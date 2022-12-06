
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://kit.fontawesome.com/0903abc57d.js" crossorigin="anonymous"></script>
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
    />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

<section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom" style="background-color: #008080;border-bottom: 3px solid #ccc!important;">
    <!-- Left -->
    <div class="me-5 d-none d-lg-block ">
        <a class="nav-link"
           href="mailto:nguyenduyanhvu2812@gmail.com" 
           ><i class="fa-solid fa-envelope"></i
            > nguyenduyanhvu2812@gmail.com</a>
    </div>
    <div class="me-5 d-none d-lg-block">
        <a class="nav-link"
           href="<c:url value="/login" />" 
           ><i class="fa-solid fa-phone"></i
            > 0356665434</a>
    </div>
    <!-- Left -->

    <!-- Right -->
    <div style="margin-right:30px">
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name == null}">
                <a
                    class="btn btn-primary btn-floating m-1"
                    style="background-color: #333333;border: none"
                    href="<c:url value="/login" />" 
                    role="button"
                    ><i class="fa fa-unlock-alt"></i
                    > Đăng Nhập</a>
                <a
                    class="btn btn-primary btn-floating m-1"
                    style="background-color: #333333;border: none"
                    href="<c:url value="/register" />"
                    role="button"
                    ><i class="fa fa-user"></i
                    > Đăng kí</a>
                </c:when>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                <a
                    class="btn btn-primary btn-floating m-1"
                    style="background-color: #333333;border: none"
                    href="<c:url value="/thongtin" />" 
                    role="button"
                    ><i class="fa fa-user"></i
                    > Tài khoản</a>
                <a
                    class="btn btn-primary btn-floating m-1 "
                    style="background-color: #333333;border: none"
                    href="<c:url value="/logout" />" 
                    role="button"
                    ><i class="fa-sharp fa-solid fa-right-to-bracket"></i
                    > Đăng Xuất</a>
                </c:when>
            </c:choose>

</section>

<header>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
            <a  class="navbar-brand animate__animated animate__flipInX" href="<c:url value="/" />">ONLINEFOODS </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="navbar-nav me-auto">
                    <c:forEach var ="t" items="${listloaisanpham}">
                        <c:url value="/" var="typePath">
                            <c:param name="loaisanphamid" value="${t.id}" />
                        </c:url>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="${typePath}"> ${t.tenloaiSP}</a>
                        </li>
                    </c:forEach>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/thanhtoan"/>" >Thanh toán</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/cart-detail" />">
                            <span  id="cartCounter" class="badge badge-pill bg-danger">${cartCounter}</span>
                            <span><i class="fas fa-shopping-cart"></i></span>
                        </a>
                    </li>

                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="nav-item dropdown" style="padding-top: 8px;
                            font-size: 18px;">
                            <a style="padding: 10px" class="text-danger" href="<c:url value="/admin/sanpham" />" role="button">Quản lý</a>

                        </li>
                    </sec:authorize>


                    <c:choose>
                        <c:when test="${pageContext.request.userPrincipal.name != null}">

                            <li class="nav-item"> 
                                <a class="nav-link " href="<c:url value="/thongtin" />" >
                                    <img src="${currentUser.avatar}" class="rounded-circle"
                                         height="22" alt="Avatar" loading="lazy" />

                                    ${pageContext.request.userPrincipal.name}</a>
                            </li>
                        </c:when>
                    </c:choose>

                </ul>
                <c:url value="/" var="action" />
                <form class="d-flex" method="get" action="${action}" >

                    <input class="form-control me-2" type="text" placeholder="Nhập từ khóa" name="kw"  >
                    <button type="submit" class="btn btn-outline-info"> Tìm </button>
                </form>
            </div>
        </div>
    </nav>
</header>
