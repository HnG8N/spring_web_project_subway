<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="Logged_in_ID" value="${Logged_in_ID }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<div>
<c:import url="../adminheaderfooter/header.jsp" />
</div>
<div>
	<h2 style="color:#000">Login</h2>
</div>
<div>
	<form action="/admin/home" method="post" id="loginForm" name="loginForm">
		ID : <input type="text" id="loginID" name="loginID"><br>
		<br>
		PW : <input type="text" id="loginPW" name="loginPW"><br>
		<br>
		<input type="button" name="loginBtn" id="loginBtn" value="Login" >
	</form>
<br>
<br>
</div>
<div>
	<c:import url="../adminheaderfooter/footer.jsp" />
</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="/js/admin/login.js"></script>
</html>