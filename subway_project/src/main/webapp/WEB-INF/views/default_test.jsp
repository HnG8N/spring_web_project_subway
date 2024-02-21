<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Default Page(실험용)</title>
<link href="/css/default_test.css" rel="stylesheet">
</head>
<body>
	<c:forEach items="${default_test}" var="default_test">
		<ul>
			<li>ID : ${default_test.mid }</li>
			<li>PW : ${default_test.mpw }</li>
		</ul>
	</c:forEach>
	<img class="image-class" src="/images/cat1.png" onclick="clickImage()">
</body>
<script src="/js/default_test.js"></script>
</html>