<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="<c:url value ="/css/style.css"/>" />


<button class="btn btn-primary" id="loading">
    <span class="spinner-border spinner-border-sm"></span>
    Loading..
</button>


<c:if test="${err!=null}" >
    <div class ="alert alert-danger">
        ${err}
    </div>
</c:if>


<c:url value="/admin/sanpham" var="action" />
<form:form method="post" action="${action}"  modelAttribute="sanpham" enctype="multipart/form-data"  >
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="tensanpham" class="form-control" id="name" placeholder="name" name="name" required="required" />
        <label for="name">Tên sản phẩm</label>
    </div>
    <div style="margin-bottom: 15px" >
        <label for="name">Giá sản phẩm(VND)</label>
        <form:input type="number" path="giaSp" class="form-control" id="giasp" required="required" />
    </div>
    <div style="margin-bottom: 15px" >
        <label for="name">Khối lượng(Gam)</label>
        <form:input type="number" path="khoiluong" class="form-control" required="required"  />
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="textarea" path="mota" class="form-control" id="name" placeholder="name" name="name" required="required" />
        <label for="name">Mô tả sản phẩm</label>
    </div>
    <div class="form-floating"  style="margin-bottom: 15px" >
        <form:select path="loaisanpham" class="form-select" id="type" name="type" required="required">
            <c:forEach items="${listloaisanpham}" var="t">
                <option value="${t.id}">${t.tenloaiSP}</option>
            </c:forEach>
        </form:select>
        <label for="sel1" class="form-label">Loại sản phẩm</label>
    </div>
    <div class="form-label">
        <form:input type="file" path="file" class="form-control" id="file" required="required" />
    </div>
    <div style="margin: 5px">
        <button type="submit" class="btn btn-success">Thêm Sản phẩm</button>
    </div>

</form:form>

<table class="table table-bordered table-sm">
    <thead  style="width: 100%;background-color: #FFB6C1">
        <tr>
            <th style="width: 10%">ID</th>
            <th>Ảnh</th>
            <th>Tên sản phẩm</th>
            <th>Khối lượng</th>
            <th>Giá</th>
            <th></th>
        </tr>
    </thead>
    <tbody id="adminSanpham">

    </tbody>
</table>

<script src="<c:url value="/js/adminSanpham.js" />"></script>
<script>
    <c:url value="/api/sanpham" var="u" />
    <c:url value="/admin/sanpham/" var="edit" />
    window.onload = function () {
        getSanpham('${u}','${edit}');
    }
</script>
