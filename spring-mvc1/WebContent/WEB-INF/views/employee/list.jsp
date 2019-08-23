<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Home Page</title>
</head>
<body>
<h3>Server: ${serverTime}</h3>

<table>
    <!-- here should go some titles... -->
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Title</th>
    </tr>
    <c:forEach items="${emp}" var="em">
    <tr>
        <td>${em.id}</td>
        <td>${em.name}</td>
        <td>${em.title}</td>
    </tr>
    </c:forEach>
</table>

<br>
<a href="${contextPath}/">Voltar</a>
</body>
</html>