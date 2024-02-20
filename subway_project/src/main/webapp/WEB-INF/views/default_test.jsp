<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Default Page(실험용)</title>
</head>
<body>
	<c:forEach items="${default_test}" var="default_test">
		<ul>
			<li>ID : ${default_test.mid }</li>
			<li>PW : ${default_test.mpw }</li>
		</ul>
	</c:forEach>
	<img src="images/cat1.png">
</body>
</html>