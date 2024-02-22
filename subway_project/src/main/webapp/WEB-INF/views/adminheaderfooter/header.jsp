<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="welcome" value="${welcome }" />
<!DOCTYPE html>
<link rel="stylesheet" href="/views/adminheaderfooter/header.css">
<header>
	<input type="hidden" id=welcome value="${welcome }">
	<div id=logoutForm>
	</div>
    <h1>Subway Management</h1>
    <div class="header-buttons">
        <a href="salesstatus">매출현황</a>
        <a href="productlist">상품 리스트</a>
        <a href="#">매장 리스트</a>
        <a href="memberinformation">회원정보조회</a>
    </div>
</header>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="/views/adminheaderfooter/header.js"></script>
