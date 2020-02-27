<%--
  Created by IntelliJ IDEA.
  User: Laptop88
  Date: 11/2/2019
  Time: 4:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.daovantam.util.SecurityUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value='/trang-chu'/>">Trang chủ
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <security:authorize access="isAnonymous()">
                    <%--khi chưa đăng nhập sẽ vào đây--%>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/dang-nhap'/>">Đăng nhập</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Đăng ký</a>
                    </li>
                </security:authorize>

                <security:authorize access="isAuthenticated()">
                    <%--khi đăng nhập rồi--%>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Wellcome <%=SecurityUtils.getPrincipal().getFullName()%></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/thoat'/>">Thoát</a>
                    </li>
                </security:authorize>
            </ul>
        </div>
    </div>
</nav>
