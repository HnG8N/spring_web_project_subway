<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 현황</title>
    <link href="../css/admin/home.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
</head>
<body>
<div>
	<c:import url="../adminheaderfooter/header.jsp" />
</div>
<div class="content">
	<p><h2>매출 현황</h2>
</div>
<div>
    <form action="daystatus" style="display: inline;" method="post">
        <input type="submit" id="daystatus" value="일일 매출 현황 검색">
    </form>&nbsp;&nbsp;&nbsp;
    <form action="piestatus" style="display: inline;" method="post">
        <input type="submit" id="piestatus" value="일일 메뉴판매 현황 검색">
    </form>
</div>
<div>
  <canvas id="myChart"></canvas>
</div>
<div>
	<c:import url="../adminheaderfooter/footer.jsp" />
</div>
</body>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script src="../js/admin/barchart.js"></script>
</html>