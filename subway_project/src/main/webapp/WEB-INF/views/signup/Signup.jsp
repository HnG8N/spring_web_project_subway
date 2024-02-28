<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
  	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <!-- Signup.js 연결 -->
    <script src="js/signup/signup.js"></script>
    <!-- 다음 주소 api 연결 -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <title>회원가입</title>
    <link href="http://subway.co.kr/" rel="canonical" />
    <meta content="신선하고 건강한 글로벌 NO.1 샌드위치 브랜드, 써브웨이" name="description" />
    <link rel="shortcut icon" type="image/x-icon" href="/images/common/subway_favicon.ico?v=2023051202" />
    <link rel="stylesheet" type="text/css" href="/css/ui.common.css?v=2023051202" />
    <link rel="stylesheet" type="text/css" href="/css/jquery.mCustomScrollbar.min.css?v=2023051202" />
	<link rel="stylesheet" type="text/css" href="/css/ui.common.css?v=2023051202" />
	<link rel="stylesheet" type="text/css" href="/css/ui.main.css?v=2023051202" />
	<link rel="stylesheet" type="text/css" href="/css/ui.menu.css?v=2023051202" />
	<link rel="stylesheet" type="text/css" href="/css/ui.order.css?v=2023051202" />
	<link rel="stylesheet" type="text/css" href="/css/jquery.mCustomScrollbar.min.css?v=2023051202" />
    <script type="text/javascript" src="/js/jquery/jquery-1.12.4.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery-ui-1.12.0.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.easing.1.3.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.bxslider.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.mCustomScrollbar.concat.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.blockUI.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/TweenMax.min.js?v=2023051202"></script>
    <script type="text/javascript" src="./js/jquery/jquery.cookie.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/ui.common.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/subway.common.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/util/jsrender.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.tmpl.min.js?v=2023051202"></script>
	<script type="text/javascript" src="/js/waffle/waffle.utils.js?v=2023051202"></script>
  </head>
  <style>
  	#center-container {
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    height: 100vh;
	}
	
	#value {
	    margin-bottom: 20px; /* 각 value 요소 사이의 간격 조정 */
	}
	
	#container {
		background-color: #ffffff;
	    text-align: center; /* 내부 요소들을 가로로 중앙 정렬 */
	}
	
	#container input[type="text"],input[type="password"],
	#container select {
	    width: 100px; /* 예시로 200px로 크기를 지정합니다. 필요에 따라 조정하세요. */
	    padding: 5px; /* 입력 요소 주변에 간격을 추가합니다. */
	    margin-bottom: 10px;
	    font-size: 16px; /* 폰트 크기를 설정합니다. */
	}
	
	header {
	    margin-bottom: 100px; /* 헤더 아래쪽에 20px의 마진을 추가합니다. */
	}
	
	footer {
	    margin-top: 100px; /* 푸터 위쪽에 20px의 마진을 추가합니다. */
	}
	
	h1{
	 margin-bottom: 50px;
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
	input[type="button"],
	button {
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
	input[type="button"]:hover,
	button:hover {
	    background-color: #666666; /* 호버 상태일 때의 배경색 */
	}
  </style>
  <body>
    <%@ include file="../include/header.jsp"%>
    <!-- container s -->
    <div id="center-container">
        <div id="container">
            <div id="content">
            
                <h1>회원가입</h1>
				<!-- 회원가입 정보 작성하는 form. submit 클릭 시 데이터베이스에 insert 됨 -->
                <form action="signupDo" method="post" onsubmit="return validation()">
                	
                    <div id="value">
                        아이디 : <input type="text" id="id" name="id" style="width:200px">
                        <button type="button" id="checkid">아이디 중복 검사</button>
                        <br>
                        <div id="result"></div>
                    </div>

                    <div id="value">
                        비밀번호 : <input type="password" id="pw" oninput="pwCheck()" name="pw" style="width:200px"><br>
                        비밀번호 확인 : <input type="password" id="pwcheck" oninput="pwCheck()" name="pwcheck" style="width:200px"><br>
                        <div id="result4"></div>
                    </div>

                    <div id="value">
                        이름 : <input type="text" id="name" name="name" style="width:200px"><br>
                    </div>

                    <div id="value">
                        주소 : <input type="text" id="postcode" name="postcode" placeholder="우편번호" readonly="readonly"> 
                        <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
                        <input type="text" id="address" name="address" placeholder="주소" readonly="readonly" style="width:300px"><br> 
                        <input type="text" id="detailAddress" name="detailAddress" placeholder="상세주소" style="width:150px">
                        <input type="text" id="extraAddress" name="extraAddress" placeholder="참고항목" readonly="readonly" style="width:150px"><br>
                    </div>

                    <div id="value">
                        생년월일 : <select name="year" id="yearSelect" name="year">
                            <c:forEach var="i" begin="1924" end="2024">
                                <option><c:out value="${i}" /></option>
                            </c:forEach>
                        </select>년 
                        <select name="month" id="monthSelect" name="month" onchange="updateDays()">
                            <c:forEach var="i" begin="1" end="12">
                                <option><c:out value="${i}" /></option>
                            </c:forEach>
                        </select>월 
                        <select name="day" id="daySelect" name="day">
                            <c:forEach var="i" begin="1" end="31">
                                <option><c:out value="${i}" /></option>
                            </c:forEach>
                        </select>일<br>
                    </div>

                    <div id="value">
                        전화번호 : <select name="start">
		                            <option>010</option>
		                            <option>011</option>
                        		</select> 
                        - <input type="text" id="mid" name="mid" maxlength="4"> 
                        - <input type="text" id="end" name="end" maxlength="4"><br>
                    </div>

                    <div id="value">
                        이메일 : <input type="text" id="email1" name="email1" style="width:200px"> 
                        @ <select id="email2" name="email2">
                            <option>naver.com</option>
                            <option>gmail.com</option>
                        </select>
                        
                        <button type="button" id="sendemail">인증번호 발송</button>
                        <br>
                        <div id="result2"></div>
                    </div>

                    <div id="value">
                        인증번호 : <input type="text" id="emailcode" maxlength="4" style="width:150px">
                        <button type="button" id="codecheck">인증확인</button>
                        <br>
                        <div id="result3"></div>
                    </div>

                    <input type="submit" value="회원가입">
                </form>
            </div>
        </div>
    </div>
    <!-- end -->
    <%@ include file="../include/footer.jsp"%>
</body>

</html>