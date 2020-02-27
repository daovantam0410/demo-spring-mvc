<%--
  Created by IntelliJ IDEA.
  User: Laptop88
  Date: 11/2/2019
  Time: 3:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Trang chủ</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="<c:url value='/template/web/css/small-business.css'/>" rel="stylesheet" type="text/css">
</head>
<body>

<!-- Navigation -->
    <%@include file="/common/web/header.jsp"%>

<!-- Page Content -->
    <dec:body/>
<!-- /.container -->

<!-- Footer -->
    <%@include file="/common/web/footer.jsp"%>

<!-- Bootstrap core JavaScript -->

<script src="<c:url value='/template/web/vendor/jquery/jquery.min.js'/>"></script>

<script src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>
