<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="js/signup/findPw.js"></script>
<title>비밀번호 찾기</title>
<link rel="shortcut icon" type="image/x-icon"
	href="/images/common/subway_favicon.ico?v=2023051202" />
<!-- 20180131 -->
<link rel="stylesheet" type="text/css"
	href="/css/ui.common.css?v=2023051202" />
<link rel="stylesheet" type="text/css"
	href="/css/jquery.mCustomScrollbar.min.css?v=2023051202" />

<link rel="stylesheet" type="text/css"
	href="/css/ui.common.css?v=2023051202" />
<link rel="stylesheet" type="text/css"
	href="/css/ui.main.css?v=2023051202" />
<link rel="stylesheet" type="text/css"
	href="/css/ui.menu.css?v=2023051202" />
<link rel="stylesheet" type="text/css"
	href="/css/ui.order.css?v=2023051202" />
<link rel="stylesheet" type="text/css"
	href="/css/jquery.mCustomScrollbar.min.css?v=2023051202" />

<script type="text/javascript"
	src="/js/jquery/jquery-1.12.4.min.js?v=2023051202"></script>
<script type="text/javascript"
	src="/js/jquery/jquery-ui-1.12.0.min.js?v=2023051202"></script>
<script type="text/javascript"
	src="/js/jquery/jquery.easing.1.3.min.js?v=2023051202"></script>
<script type="text/javascript"
	src="/js/jquery/jquery.bxslider.min.js?v=2023051202"></script>
<script type="text/javascript"
	src="/js/jquery/jquery.mCustomScrollbar.concat.min.js?v=2023051202"></script>
<!-- block ui -->
<script type="text/javascript"
	src="/js/jquery/jquery.blockUI.min.js?v=2023051202"></script>

<script type="text/javascript"
	src="/js/jquery/TweenMax.min.js?v=2023051202"></script>
<script type="text/javascript"
	src="./js/jquery/jquery.cookie.js?v=2023051202"></script>
<!--<script type="text/javascript" th:src="'/js/lottie.js?v=' + ${cacheParam}"></script>-->
<script type="text/javascript" src="/js/ui.common.js?v=2023051202"></script>
<script type="text/javascript" src="/js/subway.common.js?v=2023051202"></script>
<script type="text/javascript" src="/js/util/jsrender.js?v=2023051202"></script>
<script type="text/javascript"
	src="/js/jquery/jquery.tmpl.min.js?v=2023051202"></script>
<script type="text/javascript"
	src="/js/waffle/waffle.utils.js?v=2023051202"></script>

<style>
body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
}

#container {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 500px;
	height: auto; /* 높이 자동 조정 */
	padding: 20px;
	border: 1px solid #ccc;
	background-color: #f9f9f9;
	overflow-y: auto; /* 세로 스크롤바가 필요할 때만 표시 */
	max-height: 80vh; /* 높이 조정 */
	text-align: center; /* 가운데 정렬 추가 */
}

button {
	position: absolute;
	left: 170px;
}

.form-group {
	margin-bottom: 1.5rem;
	text-align: center; /* 항목들은 왼쪽 정렬 */
}

h1 {
	margin-bottom: 50px;
}

input[type="button"] {
	background-color: #4CAF50; /* 초록색 배경색 */
	color: white; /* 텍스트 색상 */
	padding: 10px 20px; /* 안쪽 여백 설정 */
	border: none; /* 테두리 제거 */
	border-radius: 5px; /* 모서리를 둥글게 만듭니다. */
	cursor: pointer; /* 마우스 커서를 포인터로 변경하여 클릭 가능함을 나타냅니다. */
}

#container input[type="text"], input[type="password"], #container select
	{
	width: 100px; /* 예시로 200px로 크기를 지정합니다. 필요에 따라 조정하세요. */
	padding: 5px; /* 입력 요소 주변에 간격을 추가합니다. */
	margin-bottom: 10px;
	font-size: 16px; /* 폰트 크기를 설정합니다. */
}
	header {
	    margin-bottom: 150px; /* 헤더 아래쪽에 20px의 마진을 추가합니다. */
	}

footer {
	position: fixed;
	bottom: 0;
	width: 100%;
	background-color: #333;
	color: #fff;
	text-align: center;
	padding: 10px 0;
	 margin-top: 150px; /* 푸터 위쪽에 20px의 마진을 추가합니다. */
}
</style>
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<!-- container s -->
	<div id="container">
		<h1>비밀번호 찾기</h1>
		<form action="findPwDo" method="post" name="findPwForm">

			<div class="form-group">
				아이디 : <input type="text" id="id" name="id"><br>
			</div>

			<div class="form-group">
				이름 : <input type="text" id="name" name="name"><br>
			</div>

			<div class="form-group">
				생년월일 : <select name="year" id="yearSelect" name="year">
					<c:forEach var="i" begin="1924" end="2024">
						<option><c:out value="${i}" /></option>
					</c:forEach>
				</select>년 <select name="month" id="monthSelect" name="month"
					onchange="updateDays()">
					<c:forEach var="i" begin="1" end="12">
						<option><c:out value="${i}" /></option>
					</c:forEach>
				</select>월 <select name="day" id="daySelect" name="day">
					<c:forEach var="i" begin="1" end="31">
						<option><c:out value="${i}" /></option>
					</c:forEach>
				</select>일<br>
			</div>

			<div class="form-group">
				이메일 : <input type="text" id="email1" name="email1"> @ <select
					id="email2" name="email2">
					<option>naver.com</option>
					<option>gmail.com</option>
				</select>
			</div>
			<br> <input type="button" value="비밀번호 찾기" id="findPw">
		</form>
	</div>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>