<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="js/mypage/mypage.js"></script>
<title>회원정보 수정</title>
<meta content="신선하고 건강한 글로벌 NO.1 샌드위치 브랜드, 써브웨이" name="description" />
<!-- 20181212 -->
<link rel="shortcut icon" type="image/x-icon"
	href="/images/common/subway_favicon.ico?v=2023051202" />
<!-- 20180131 -->
<link rel="stylesheet" type="text/css"
	href="/css/ui.common.css?v=2023051202" />
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
	src="/js/jquery/jquery.cookie.js?v=2023051202"></script>
<!--<script type="text/javascript" th:src="'/js/lottie.js?v=' + ${cacheParam}"></script>-->
<script type="text/javascript" src="/js/ui.common.js?v=2023051202"></script>
<script type="text/javascript" src="/js/subway.common.js?v=2023051202"></script>
<script type="text/javascript" src="/js/util/jsrender.js?v=2023051202"></script>
<script type="text/javascript"
	src="/js/jquery/jquery.tmpl.min.js?v=2023051202"></script>
<script type="text/javascript"
	src="/js/waffle/waffle.utils.js?v=2023051202"></script>
<script type="text/javascript" src="/js/mypage/mypage.js?v=2023051202"></script>
<link rel="stylesheet" type="text/css"
	href="/css/ui.mypage.css?v=2023051202" />

<style>
#container {
	margin: 0 auto; /* 가운데 정렬 */
	width: 80%; /* 적절한 너비 설정 */
	background-color: #ffffff; /* 배경색 흰색으로 변경 */
	padding: 10px; /* 내부 여백 추가 */
}

#content {
	margin-top: 50px;
	text-align: center; /* 내용을 가운데 정렬 */
}

#container input[type="text"], input[type="password"], #container select
	{
	width: 100px; /* 예시로 200px로 크기를 지정합니다. 필요에 따라 조정하세요. */
	padding: 5px; /* 입력 요소 주변에 간격을 추가합니다. */
	margin-bottom: 10px;
	font-size: 16px; /* 폰트 크기를 설정합니다. */
}

.form-group {
	margin-bottom: 1.5rem;
	text-align: center; /* 항목들은 왼쪽 정렬 */
}

#content>* {
	margin-bottom: 10px; /* 요소들 사이의 아래 마진 추가 */
	letter-spacing: 1px; /* 자간 설정 */
}

header {
	margin-bottom: 200px; /* 헤더 아래쪽에 20px의 마진을 추가합니다. */
}

footer {
	margin-top: 70px; /* 푸터 위쪽에 20px의 마진을 추가합니다. */
}

hr {
	margin-top: 50px;
}

input[type="submit"] {
	background-color: #4CAF50; /* 초록색 배경색 */
	color: white; /* 텍스트 색상 */
	padding: 10px 20px; /* 안쪽 여백 설정 */
	border: none; /* 테두리 제거 */
	border-radius: 5px; /* 모서리를 둥글게 만듭니다. */
	cursor: pointer; /* 마우스 커서를 포인터로 변경하여 클릭 가능함을 나타냅니다. */
}

input[type="submit"]:hover {
	background-color: #45a049; /* 호버 상태일 때의 배경색 */
}

/* input 태그의 버튼 스타일 */
/* 입력 버튼 스타일 */
input[type="button"], button {
	width: 80px; /* 너비 설정 */
	height: 30px; /* 높이는 내용에 맞게 자동으로 설정 */
	background-color: #808080; /* 배경색 */
	color: white; /* 텍스트 색상 */
	border: none; /* 테두리 제거 */
	border-radius: 5px; /* 모서리 둥글게 */
	cursor: pointer; /* 커서 모양 설정 */
	font-size: 8px; /* 폰트 크기 설정 */
	text-align: center; /* 텍스트를 가운데로 정렬 */
}

/* 호버 상태일 때의 스타일 */
input[type="button"]:hover, button:hover {
	background-color: #666666; /* 호버 상태일 때의 배경색 */
}
</style>

</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<!-- container s -->
	<div class="bg_gray" id="container">
		<!-- sub content s -->
		<div id="content">
			<div class="form-group">
				이름 : ${dto.mname }<br>
			</div>

			<div class="form-group">
				아이디 : ${dto.mid}<br>
			</div>

			<div class="form-group">
				이메일 : ${dto.memail }<br>
			</div>

			<div class="form-group">
				전화번호 : ${dto.mtel }<br>
			</div>

			<hr>
			<br>
			<br>
			<form action="updateInfo" method="post"
				onsubmit="return validation()">
				<input type="hidden" id="mypw" value="${dto.mpw }" />
				<div class="form-group">
					현재 비밀번호 : <input type="password" id="pw" style="width:200px"> <input
						type="button" id="check123" value="비밀번호 확인"><br>
				</div>


				<div class="form-group">
					<div id="changePasswordForm" style="display: none;">
						<label for="newpw">바꾸실 비밀번호: </label> <input type="password"
							id="newpw" name="newpw" oninput="pwCheck()" style="width:200px"><br>
					</div>
					<div class="form-group">
						<label for="newpwcheck">비밀번호 확인: </label> <input type="password"
							id="newpwcheck" oninput="pwCheck()" style="width:200px"><br>
					</div>
					<div class="form-group">
						<span id="result"></span>
					</div>
				</div>
				<div class="form-group">
					주소 : <input type="text" value="${dto.maddress }" id="address"
						name="address1" readonly="readonly"
						style="border: 0; width: 400px"> <input type="button"
						onclick="execDaumPostcode()" value="우편번호 찾기"><br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
						type="text" name="address2" placeholder="상세주소를 입력하세요"
						style="border: 0; width: 200px"><br>
				</div>
				<br>
				<br>
				<br>
				<div class="form-group">
					<input type="submit" id="updateInfo" value="회원정보수정">
				</div>
			</form>
			<form action="deleteInfo" method="post">
				<div class="form-group">
					<input type="submit" id="deleteInfo" value="회원탈퇴">
				</div>
			</form>

		</div>
		<!--// 내정보관리 > 정보변경 -->
	</div>
	<!--// sub content e -->
	<%@ include file="../include/footer.jsp"%>
</body>
</html>