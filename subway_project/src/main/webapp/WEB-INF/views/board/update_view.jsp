<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<form action="update" method="post">
	<table cellpadding="0" cellspacing="0" border="1">
			<tr>
			<td>
			<input type="hidden" name="boardID" value="${update_view.boardID}">
			</td>
			</tr>
			<tr>
				<td> 번호 </td>
				<td> ${update_view.boardID} </td>
			</tr>
			<tr>
				<td> 작성자 </td>
				<td> ${update_view.bmID}</td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="boTitle" value="${update_view.boTitle}"> </td>
			</tr>
			<tr>
				<td> 작성내용 </td>
				<td> <input type="text" name="boContent" value="${update_view.boContent}"> </td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="수정하기"> &nbsp;&nbsp; <a href="/board/list">목록보기</a> &nbsp;&nbsp; <a href="/board/delete?boardID=${update_view.boardID}">삭제</a> &nbsp;&nbsp; </td>
			</tr>
	</table>
		
</form>

</body>
</html>