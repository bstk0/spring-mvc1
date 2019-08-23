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
<c:forEach items="${emp}" var="em">
        <li>${em.id}</li>
        <li>${em.name}</li>
        <li>${em.title}</li>
</c:forEach>
<br>
<a href="${contextPath}/">Voltar</a>
</body>
</html>