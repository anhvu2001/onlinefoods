<%-- 
    Document   : adminEditSanpham
    Created on : Oct 8, 2022, 3:29:59 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="<c:url value ="/css/style.css"/>" />


<c:url value="/admin/sanpham/${editSanpham.id}" var="action" />
<form:form method="post" action="${action}"  modelAttribute="sanphamEdit" enctype="multipart/form-data"  >
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="tensanpham" class="form-control" id="name" placeholder="name" name="name" value="${editSanpham.tensanpham}" />
        <label for="name">Tên sản phẩm</label>
    </div>
    <div style="margin-bottom: 15px" >
        <label for="name">Giá sản phẩm(VND)</label>
        <form:input type="number" path="giaSp" class="form-control" id="giasp" value="${editSanpham.giaSp}" />
    </div>
      <div style="margin-bottom: 15px" >
        <label for="name">Khối lượng(Gam)</label>
        <form:input type="number" path="khoiluong" class="form-control" value="${editSanpham.khoiluong}"    />
    </div>
     <div class="form-floating mb-3 mt-3">
        <form:input type="textarea" path="mota" class="form-control" id="name" placeholder="name" name="name" value="${editSanpham.mota}"   />
        <label for="name">Mô tả sản phẩm</label>
    </div>
    <div class="form-floating"  style="margin-bottom: 15px" >
        <form:select path="loaisanpham" class="form-select" id="type" name="type">
            <c:forEach items="${listloaisanpham}" var="t">
                <option value="${t.id}">${t.tenloaiSP}</option>
            </c:forEach>
        </form:select>
        <label for="sel1" class="form-label">Loại sản phẩm</label>
    </div>
    <div class="form-label">
        <image style="width: 120px" src="${editSanpham.anh}" alt="anh"/>
    </div>
    <div class="form-label">
        <form:input type="file" path="file" class="form-control" id="file"  />
    </div>
    <div style="margin: 5px">
        <button type="submit" class="btn btn-success">Sửa Sản phẩm</button>
    </div>

</form:form>
