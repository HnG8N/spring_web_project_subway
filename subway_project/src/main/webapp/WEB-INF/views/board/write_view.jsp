<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>SUBWAY</title>
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
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<form action="write" method="post">
				<tr>
					<td>작성자</td>
					<td><input type="text" name="bmID" size="50" value="${userId}"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="boTitle" size="50"></td>
				</tr>
				<tr>

					<td>작성내용</td>
					<td><input type="text" name="boContent" size="50"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="입력">
						&nbsp;&nbsp; <a href="/list">목록보기</a></td>
				</tr>
			</form>
		</table>
	</div>
<%@ include file="../include/footer.jsp"%>
</body>
</html>