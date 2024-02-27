<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subway MVC 게시판</title>
</head>
<body>
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
		
		
</body>
</html>