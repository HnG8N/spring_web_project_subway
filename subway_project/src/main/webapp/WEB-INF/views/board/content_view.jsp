<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    /* 목록 스타일 변경 */
    ul {
        list-style-type: none; /* 목록 기호 제거 */
        padding: 0; /* 내부 여백 제거 */
    }
</style>
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
	<c:forEach items="${comment_view }" var="dtos">
		<ul>
			<li>
				<c:forEach begin="1" end="${dtos.commentlevel }">
					&nbsp;&nbsp;&nbsp;
				</c:forEach>
			-> group : ${dtos.commentgroup } id : ${dtos.commentuserid } date : ${dtos.commentdate }
			<br>
				<c:forEach begin="1" end="${dtos.commentlevel }">
					&nbsp;&nbsp;&nbsp;
				</c:forEach>
			<c:choose>
				<c:when test="${dtos.commentdelete == 1 }">
				<b style="color: rgba(128, 128, 128, 0.5);">삭제된 메세지 입니다.</b>
				</c:when>
				<c:when test="${dtos.commentdelete == 0}">
				&nbsp;&nbsp;&nbsp;content : ${dtos.commentcontent } 
				<button onclick="showReplyForm(${dtos.commentid})">답글</button>
				<c:if test="${userId == dtos.commentuserid}">
					<tr>
						<td colspan="2"> <button onclick="showReplyUpdateForm(${dtos.commentid})">수정</button> &nbsp;&nbsp; 
						<a href="/board/commentdelete?commentId=${dtos.commentid}&postId=${content_view.boardID}">삭제</a> &nbsp;&nbsp; </td>
					</tr>
				</c:if>
				</c:when>
			</c:choose>
                <form id="replyForm${dtos.commentid}" action="reply" method="post" style="display: none;">
                    <input type="hidden" name="boardID" value="${content_view.boardID}">
                    <input type="hidden" name="postId" value="${content_view.boardID}">
                    <input type="hidden" name="commentGroup" value="${dtos.commentgroup}">
                    <input type="hidden" name="commentId" value="${dtos.commentid}">
                    <input type="hidden" name="commentLevel" value="${dtos.commentlevel}">
                    <textarea name="commentContent" rows="4" cols="50" placeholder="답글"></textarea>
                    <input type="submit" value="답글 작성">
                </form>
                <form id="replyUpdateForm${dtos.commentid}" action="replyUpdate" method="post" style="display: none;">
                    <input type="hidden" name="commentId" value="${dtos.commentid}">
                    <textarea name="commentContent" rows="4" cols="50" placeholder="수정">${dtos.commentcontent }</textarea>
					<input type="hidden" name="postId" value="${content_view.boardID}">
                    <input type="submit" value="답글 수정">
                </form>
			</li>
		</ul>	
	</c:forEach>
	<form action="comment" method="post">
		<input type="hidden" name="postId" value="${content_view.boardID}">
		<input type="hidden" name="commentId" value="${dtos.commentid}">
		<input type="hidden" name="commentGroup" value="${comment_group}">
		<textarea name="commentContent" rows="4" cols="50" placeholder="댓글"></textarea>
		<input type="submit" value="댓글 작성">
	</form>
</body>
<script>
    function showReplyForm(commentId) {
        // 해당 댓글의 답글 작성 폼을 표시합니다.
        var replyForm = document.getElementById('replyForm' + commentId);
        if (replyForm.style.display === 'none') {
            replyForm.style.display = 'block';
        } else {
            replyForm.style.display = 'none';
        }
    }
    function showReplyUpdateForm(commentId) {
        // 해당 댓글의 답글 수정 폼을 표시합니다.
        var replyUpdateForm = document.getElementById('replyUpdateForm' + commentId);
        if (replyUpdateForm.style.display === 'none') {
        	replyUpdateForm.style.display = 'block';
        } else {
        	replyUpdateForm.style.display = 'none';
        }
    }
</script>
</html>