<%-- 
    Document   : adminAnhsanpham
    Created on : Sep 29, 2022, 6:51:22 PM
    Author     : ADMIN
--%>

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


<c:url value="/admin/sanpham/anh" var="action" />
<div class="row" style="margin-top: 10px">
    <div class="col-md-6">
        <table class="table table-bordered table-sm" style="width: 100%">
            <thead  style="background-color: #FFB6C1">
                <tr>
                    <th>ID</th>
                    <th>Ảnh</th>
                    <th>Tên sản phẩm</th>
                    <th>Loại Sản phẩm</th>
                    <th>Xóa ảnh Sản phẩm</th>
                </tr>
            </thead>
            <tbody id="adminAnhsanpham">

            </tbody>
        </table>
    </div>
    <div class="col-md-6">
        <form:form method="post" action="${action}"  modelAttribute="anhsanpham" enctype="multipart/form-data"  >
            <div class="form-label">
                <form:input type="file" path="file" class="form-control" id="file" required="required" />
            </div>
            <div class="form-floating"  style="margin-bottom: 15px" >
                <form:select path="sanphamid" class="form-select" id="type" name="type">
                    <c:forEach items="${listAllsanpham}" var="t">
                        <option value="${t.id}">${t.tensanpham}</option>
                    </c:forEach>
                </form:select>
                <label for="sel1" class="form-label">Loại sản phẩm</label>
            </div>
            <div style="margin: 5px">
                <button type="submit" class="btn btn-success">Thêm ảnh cho sản phẩm</button>
            </div>
        </form:form>
    </div>
</div>



<script src="<c:url value="/js/adminAnhsanpham.js" />"></script>
<script>
    <c:url value="/api/anhsanpham" var="u" />
    window.onload = function () {
        getAnhSanpham('${u}');
    }
</script>
<c:if test="${t.tinhTrang == false}">
                    <td class="text-danger">Chưa thanh toán</td>

                    <td><button class='btn btn-success' onclick="confirmHoaDon('${u}')">Xác nhận</button></td>
                </c:if>

                <c:if test="${t.tinhTrang == true}">
                    <td>Đã thanh toán</td>
                    <td></td>
                </c:if>