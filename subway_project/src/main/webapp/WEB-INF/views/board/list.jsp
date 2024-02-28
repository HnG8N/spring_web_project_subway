<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>SUBWAY - 이용후기 </title>
    <meta content="신선하고 건강한 글로벌 NO.1 샌드위치 브랜드, 써브웨이" name="description" /><!-- 20181212 -->
    <link rel="shortcut icon" type="image/x-icon" href="/images/common/subway_favicon.ico?v=2023051202" />
    <!-- 20180131 -->
    <link rel="stylesheet" type="text/css" href="/css/ui.common.css?v=2023051202" />
    <link rel="stylesheet" type="text/css" href="/css/jquery.mCustomScrollbar.min.css?v=2023051202" />

    <script type="text/javascript" src="/js/jquery/jquery-1.12.4.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery-ui-1.12.0.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.easing.1.3.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.bxslider.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.mCustomScrollbar.concat.min.js?v=2023051202"></script>
    <!-- block ui -->
    <script type="text/javascript" src="/js/jquery/jquery.blockUI.min.js?v=2023051202"></script>

    <script type="text/javascript" src="/js/jquery/TweenMax.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.cookie.js?v=2023051202"></script>
    <!--<script type="text/javascript" th:src="'/js/lottie.js?v=' + ${cacheParam}"></script>-->
    <script type="text/javascript" src="/js/ui.common.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/subway.common.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/util/jsrender.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.tmpl.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/waffle/waffle.utils.js?v=2023051202"></script>
</head>
<body>
<%@ include file="../include/header.jsp"%>
	<div id="container">
	<h1>Subway 게시판</h1>
	
	<a href="write_view">글등록</a>
	<br>
		<form action="/board/listQuery" method="post">
	검색 선택 :
	<select name="query">
		<option value="bmID">사용자</option>	
		<option value="boTitle" selected="selected">글제목</option>			
	</select>&nbsp;&nbsp;&nbsp;
		<input type="text" name="content" size="30">
		<input type="submit" value="검색">
	</form>
	<br> 
	<table border="1">
		<tr>
			<th bgcolor="#808080">번호</th>
			<th bgcolor="#808080">제목</th>
			<th bgcolor="#808080">작성자</th>
			<th bgcolor="#808080">작성일</th>
			<th bgcolor="#808080">조회수</th>			
		</tr>
		<c:set var="cnt" value="0"/>
		<c:forEach items="${list}" var="dto">
		<tr>			
			<td>${dto.boardID}</td>
			<td><a href="content_view?boardID=${dto.boardID}">${dto.boTitle}</a></td>
			<td>${dto.bmID}</td>
			<td>${dto.boDate}</td>
			<td>${dto.boardHit}</td>	
					
		</tr>
		<c:set var="cnt" value="${cnt=cnt+1 }"/>
		</c:forEach>
		</table>
		<br><br>
		<p>검색 결과는 <b>${cnt}</b>건 입니다.</p>
		
	</div>
<%@ include file="../include/footer.jsp"%>	
</body>
</html>