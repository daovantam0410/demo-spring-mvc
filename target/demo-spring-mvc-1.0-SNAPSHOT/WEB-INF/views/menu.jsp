<%--
  Created by IntelliJ IDEA.
  User: Laptop88
  Date: 11/2/2019
  Time: 12:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul>
    <c:forEach var="item" items="${menu}">
        <li>${item}</li>
    </c:forEach>
</ul>
