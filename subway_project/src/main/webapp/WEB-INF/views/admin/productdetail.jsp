<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dto" value="${MENU }" />
<!DOCTYPE html>
<html>
<head>
<title>상품 관리</title>
</head>
	<style>
	#img {
	    width: 250px; /* 너비를 250px로 설정 */
	    height: auto; /* 높이를 auto로 설정 */
	    object-fit: contain;
	}
	#imgPreview {
	    width: 250px; /* 너비를 250px로 설정 */
	    height: auto; /* 높이를 auto로 설정 */
	    object-fit: contain;
	}
	</style>
<link href="../css/admin/home.css" rel="stylesheet" />
<body>
<div>
	<c:import url="../adminheaderfooter/header.jsp" />
</div>
<div>
<form action="productupdateDB" name="product" id="product" method="post" enctype="multipart/form-data" class="product">
	<section style="display: flex;">
	    <div style="flex: 1;">
			<h2>상품 수정</h2>
            상품코드:
            <input type="text" id="mncode" name="mncode" readonly="readonly" placeholder="상품코드는 자동으로 입력됩니다." size="25" value="${dto.mncode }"><br>
            <br>
		    카테고리:
		    <select name="mnctg" id="mnctg">
		    	<option value="sandwich">sandwich</option>
		    	<option value="salad">salad</option>
		    	<option value="wrap">wrap</option>
		    </select>
			<input type="hidden" id="mnctgtext" name="mnctgtext" placeholder="카테고리를 선택해주세요." value="${dto.mnctg }" readonly="readonly"><br>
			<br>
			이름:
			<input type="text" id="mnname" name="mnname" placeholder="한글명을 입력해주세요. (&과 공백 가능)" size="30" value="${dto.mnname }"><br>
			<br>
			영문명:
			<input type="text" id="mnengname" name="mnengname" placeholder="영문명을 입력해주세요. (&과 공백 가능)" size="30" value="${dto.mnengname }"><br>
			<br>
			상세정보:<br>
			<textarea id="mninfo" name="mninfo" rows="10" cols="50" placeholder="상세정보를 입력해주세요.">${dto.mninfo }</textarea><br>
			<br>
			가격:
			<input type="text" id="mnprice" name="mnprice" placeholder="가격을 입력해주세요. (숫자만 가능)" size="30" value="${dto.mnprice }"><br>
			<br>
			이미지:
			<input type="file" id="mnimg" name="mnimg" onchange="previewImage(event)"><br>
			<img id="imgPreview" src="../images/cat1.png" alt="이미지를 등록 해주세요."/>
	    </div>
	    <div style="flex: 1;">
	        <h2>영양성분표 수정</h2>
			중량(g):
			<input type="text" id="mngram" name="mngram" placeholder="중량(g)을 입력해주세요. (숫자만 가능)" size="40" value="${dto.mngram }"><br>
			<br>
			열량(kcal):
			<input type="text" id="mnkcal" name="mnkcal" placeholder="열량(Kcal)을 입력해주세요. (숫자만 가능)" size="40" value="${dto.mnkcal }"><br>
			<br>
			단백질(g):
			<input type="text" id="mnprotein" name="mnprotein" placeholder="단백질(g)을 입력해주세요. (숫자만 가능)" size="40" value="${dto.mnprotein }"><br>
			<br>
			포화지방(g):
			<input type="text" id="mnfat" name="mnfat" placeholder="포화지방(g)을 입력해주세요. (숫자만 가능)" size="40" value="${dto.mnfat }"><br>
			<br>
			당류(g):
			<input type="text" id="mnsugar" name="mnsugar" placeholder="당류(g)을 입력해주세요. (숫자만 가능)" size="40" value="${dto.mnsugar }"><br>
			<br>
			나트륨(mg):
			<input type="text" id="mnnatrum" name="mnnatrum" placeholder="나트륨(mg)을 입력해주세요. (숫자만 가능)" size="40" value="${dto.mnnatrum }"><br>
			<br>
			<img id="img" name="img" src="../views/upload/menu/${dto.mnimg }" alt="..."/><br>
			<button type="submit" name="insertBtn" id="insertBtn" value="insertBtn">입력</button>
	    </div>
	</section>
</form>
</div>
<div>
	<c:import url="../adminheaderfooter/footer.jsp" />
</div>
</body>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
<script src="../js/admin/productdetail.js"></script>
</html>