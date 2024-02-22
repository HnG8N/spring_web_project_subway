<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="Logged_in_ID" value="${Logged_in_ID }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<div>
	<c:import url="../adminheaderfooter/header.jsp" />
</div>
<div>
	<h2 style="color:#000">시작 페이지 입니다!!!</h2>
	test : ${Logged_in_ID }
</div>
<div>
	<c:import url="../adminheaderfooter/footer.jsp" />
</div>
</body>
</html>