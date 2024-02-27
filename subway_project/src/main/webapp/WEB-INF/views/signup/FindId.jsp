<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="js/signup/findId.js"></script>
	<title>아이디 찾기</title>
	<link href="http://subway.co.kr/" rel="canonical" /><!-- 20180221 -->
    <meta content="신선하고 건강한 글로벌 NO.1 샌드위치 브랜드, 써브웨이" name="description" /><!-- 20181212 -->
    <link rel="shortcut icon" type="image/x-icon" href="/images/common/subway_favicon.ico?v=2023051202" />
    <!-- 20180131 -->
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
    <!-- block ui -->
    <script type="text/javascript" src="/js/jquery/jquery.blockUI.min.js?v=2023051202"></script>

    <script type="text/javascript" src="/js/jquery/TweenMax.min.js?v=2023051202"></script>
    <script type="text/javascript" src="./js/jquery/jquery.cookie.js?v=2023051202"></script>
    <!--<script type="text/javascript" th:src="'/js/lottie.js?v=' + ${cacheParam}"></script>-->
    <script type="text/javascript" src="/js/ui.common.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/subway.common.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/util/jsrender.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.tmpl.min.js?v=2023051202"></script>
	<script type="text/javascript" src="/js/waffle/waffle.utils.js?v=2023051202"></script>
</head>
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
        height: 300px;
        padding: 20px;
        border: 1px solid #ccc;
        background-color: #f9f9f9;
        overflow-y: auto; /* 세로 스크롤바가 필요할 때만 표시 */
        max-height: 80vh; /* 높이 조정 */
    }
    button {
        position: absolute;
        left: 170px;
    }
    .form-control {
        margin-bottom: 10px;
    }
    .form-group.row {
        margin-bottom: 1.5rem;
    }
    footer {
        position: fixed;
        bottom: 0;
        width: 100%;
        background-color: #333;
        color: #fff;
        text-align: center;
        padding: 10px 0;
    }
</style>
</head>
<body>
    <%@ include file="../include/header.jsp"%>
    <!-- container -->
    <div id="container">
        <form action="findIdDo" method="post" name="findIdForm">
            <div class="form-group">
                <label for="name">이름:</label>
                <input type="text" id="name" name="name">
            </div>
            <div class="form-group">
                <label for="birthday">생년월일:</label>
                <select name="year" id="yearSelect" name="year">
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
                </select>일
            </div>
            <div class="form-group">
                <label for="email">이메일:</label>
                <input type="text" id="email1" name="email1">
                @
                <select id="email2" name="email2">
                    <option>naver.com</option>
                    <option>gmail.com</option>
                </select>
            </div>
            <input type="button" value="아이디 찾기" id="findId">
        </form>
    </div>
    <%@ include file="../include/footer.jsp"%>
</body>
</html>