<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>SUBWAY 게시글 수정 </title>
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
		<form action="update" method="post">
			<table cellpadding="0" cellspacing="0" border="1">
				<tr>
					<td><input type="hidden" name="boardID"
						value="${update_view.boardID}"></td>
				</tr>
				<tr>
					<td>번호</td>
					<td>${update_view.boardID}</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${update_view.bmID}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="boTitle"
						value="${update_view.boTitle}"></td>
				</tr>
				<tr>
					<td>작성내용</td>
					<td>
					<textarea name="boContent" rows="20" cols="100">${update_view.boContent}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정확인">
					 &nbsp;&nbsp; <a href="/delete?boardID=${update_view.boardID}">게시글 삭제</a>
						&nbsp;&nbsp;</td>
				</tr>
			</table>
		</form>
	</div>
	<a href="board">목록보기</a>
	<br><br><br>
<%@ include file="../include/footer.jsp"%>
</body>
</html>