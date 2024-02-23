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
  </style>
</head>
<body>
<div>
	<c:import url="../adminheaderfooter/header.jsp" />
</div>
<h2 id="title">상품 리스트</h2><br>
<div class="container">
	 	<select name="selectSearch" id="selectSearch">
	 		<option value="nameSearch">이름(영문명 가능)</option>
			<option value="codeSearch">상품코드</option>
	 	</select>
	 	<input type="text" name="search" id="search">
	 	<input type="button" id="searchBtn" name="searchBtn" value="검색">
	 	<form action="productinsert" method="post" id="insertBtnForm">
	 	<input type="submit" id="insertBtn" name="insertBtn" value="새 상품 등록"> <!-- 새 상품 등록 버튼 -->
	 	</form>
	 	<br>
	 	<br>
</div>
<div id="result"></div>
<div>
	<c:import url="../adminheaderfooter/footer.jsp" />
</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="../js/admin/productlist.js"></script>
</html>