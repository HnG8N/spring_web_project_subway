<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>상품 리스트</title>
   <link href="../css/admin/home.css" rel="stylesheet" />
   <link href="../css/admin/productlist.css" rel="stylesheet">
  <style>
	.card {
		display: flex;
		align-items: center;
	}
	#title{
		text-align: center;
	}
    .container {
		display: flex;
		justify-content: space-between; /* 요소를 컨테이너의 양 끝에 정렬합니다. */
		align-items: center; /* 요소를 수직 가운데로 정렬합니다. */
    }
	.search-container {
		display: inline-block; /* 인라인 블록 요소로 설정하여 다른 요소와 함께 한 줄에 배치될 수 있도록 합니다. */
		vertical-align: middle; /* 수직 정렬을 가운데로 설정합니다. */
    }
    #selectSearch, #search {
		margin-right: 10px; /* 입력 요소 간에 간격을 설정합니다. */
    }
	#insertBtnForm {
		margin-left: auto; /* 검색 버튼을 맨 오른쪽에 배치합니다. */
	}
	/* 추가된 부분 */
	.select-container {
		display: flex;
		justify-content: flex-end;
	}
  </style>
</head>
<body>
<div>
	<c:import url="../adminheaderfooter/header.jsp" />
</div>
<h2 id="title">회원 정보</h2><br>
	<div class="container">
		<div class="select-container">
		<form action="usersearch" method="post">
			<select name="userSearch">
				<option value="MID">아이디</option>
				<option value="MNAME">이름</option>
				<option value="MADDRESS">주소</option>
			</select>
			<input type="submit" value="검색">
		</form>
		<c:forEach begin="1" end="125" >
			&nbsp;
		</c:forEach>
			<a href="memberinfo?userInfo=endUser">탈퇴회원조회</a>
			&nbsp;&nbsp;&nbsp;
			<a href="memberinfo?userInfo=regDate">가입일자순</a>
			&nbsp;&nbsp;&nbsp;
			<a href="memberinfo">초기화면</a>
		</div>
	</div>
<br>
<table style="width: 100%;">
    <tr>
        <td style="width: 10%;">아이디</td>
        <td style="width: 10%;">비밀번호</td>
        <td style="width: 10%;">이름</td>
        <td style="width: 20%;">주소</td>
        <td style="width: 10%;">전화번호</td>
        <td style="width: 10%;">생년월일</td>
        <td style="width: 10%;">이메일</td>
        <td style="width: 10%;">가입날짜</td>
        <td style="width: 10%;">탈퇴날짜</td>
    </tr>
</table>
<c:forEach var="dtos" items="${MEMBER }">
    <div class="card">
        <table style="width: 100%;">
            <tr>
                <td style="width: 10%;">${dtos.mid }</td>
                <td style="width: 10%;">${dtos.mpw }</td>
                <td style="width: 10%;">${dtos.mname }</td>
                <td style="width: 20%;">${dtos.maddress }</td>
                <td style="width: 10%;">${dtos.mtel }</td>
                <td style="width: 10%;">${dtos.mbirth }</td>
                <td style="width: 10%;">${dtos.memail }</td>
                <td style="width: 10%;">${dtos.mregdate }</td>
                <td style="width: 10%;">${dtos.menddate }</td>
            </tr>
        </table>
    </div>
</c:forEach>
<div>
	<c:import url="../adminheaderfooter/footer.jsp" />
</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="../js/admin/memberinformation.js"></script>
</html>
