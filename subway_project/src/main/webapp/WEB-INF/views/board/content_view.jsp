<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update_view" method="post">
	<table cellpadding="0" cellspacing="0" border="1">
			<tr>
			<td>
			<input type="hidden" name="boardID" value="${content_view.boardID}">
			</td>
			</tr>
			<tr>
				<td> 번호 </td>
				<td> ${content_view.boardID} </td>
			</tr>
			<tr>
				<td> 작성자 </td>
				<td> ${content_view.bmID}</td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="boTitle" value="${content_view.boTitle}"> </td>
			</tr>
			<tr>
				<td> 작성내용 </td>
				<td> <input type="text" name="boContent" value="${content_view.boContent}"> </td>
			</tr>
		<c:if test="${userId == content_view.bmID}">
			<tr>
				<td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; <a href="/board/delete?boardID=${content_view.boardID}">삭제</a> &nbsp;&nbsp; </td>
			
			</tr>
		</c:if>
		<tr><td><a href="/board/list">목록보기</a></td></tr>
	</table>
		
</form>
<table>
 	<tr>
    	<td colspan="2">
        	<form action="reply" method="post">
            	<input type="hidden" name="postId" value="">
            	<textarea name="comment" rows="4" cols="50" placeholder="댓글"></textarea><br>
            	<input type="submit" value="댓글 작성">
        	</form>
    	</td>
	</tr>
</table>
<table>
	<c:forEach items="" >
		<tr>			
			<td>id</td>
			<td>date</td>
			<td>content</td>					
		</tr>	
	</c:forEach>
</table>
</body>
</html>