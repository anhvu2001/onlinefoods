<%-- 
    Document   : tourDetail
    Created on : Aug 3, 2022, 5:30:22 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>



<link rel="stylesheet" href="<c:url value ="/css/style.css"/>" />


<c:url value="/api/cart" var="c" />
<script src="<c:url value="/js/cart.js" />"></script>
<div class="row">
    <div class="col-md-6 "style="padding:10px" >
        <div class="card" style="width:653px">
            <img class="card-img-top" id ="main" src="${sanpham.anh}" alt="Card image" style="min-height: 500px; max-height: 500px">
        </div>
    </div>
    <div class="col-md-6" style="padding:25px" >
        <h3>  ${sanpham.tensanpham}</h3>
        <p class = "text-danger">Giá sản phẩm: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${sanpham.giaSp}" /> VND</p> 
        <p class="card-title">Khối lượng: ${sanpham.khoiluong} gam</p>      
        <p class="card-title">Mô tả chi tiết: ${sanpham.mota}</p>
        <button style="margin-top: 10px" class="buttoncart" onclick="addToCart('${c}',${sanpham.id}, '${sanpham.tensanpham}', ${sanpham.giaSp}, '${sanpham.anh}')">Thêm vào giỏ</button>
    </div>       
</div>





<script>
    function changeImage(obj) {
        var path = obj.src;
        var img = document.getElementById("main");
        img.setAttribute("src", path);
    }
</script>


<div class="thumail" >
    <c:forEach items="${image}" var="c">
        <div class="items">
            <image src="${c.linkanh}" alt="anhvu" style="width:100%; height: 107px" onclick="changeImage(this)" />
        </div>
    </c:forEach>
</div>
<hr width="100%" align="right" size="5px">


<c:url value="/api/sanpham/${sanpham.id}/comments" var="t" />

<sec:authorize access="!isAuthenticated()">
    <strong>Vui lòng <a href="<c:url value="/login" />">Đăng nhập</a> để bình luận!!!</strong>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <div class="form-group" style="margin-bottom: 5px">
        <textarea class="form-control" placeholder="Nhập nội dung" id="contentId"></textarea>
    </div>
    <button class="btn btn-danger" onclick="addCommentSanpham('${t}', ${sanpham.id})" style="margin-bottom: 10px">Thêm bình luận</button>
</sec:authorize>

<ul id="comments" class="list-group">

</ul>



<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/comment.js" />"></script>
<script>
        window.onload = function () {
            loadCommentsSp('${t}');
        }
</script>









