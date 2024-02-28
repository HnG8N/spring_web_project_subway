<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>SUBWAY</title>
    <meta content="신선하고 건강한 글로벌 NO.1 샌드위치 브랜드, 써브웨이" name="description" /><!-- 20181212 -->
    <link rel="shortcut icon" type="image/x-icon" href="/images/common/subway_favicon.ico?v=2023051202" />
    <!-- 20180131 -->
    <link rel="stylesheet" type="text/css" href="/css/ui.common.css?v=2023051202" />
    <link rel="stylesheet" type="text/css" href="/css/jquery.mCustomScrollbar.min.css?v=2023051202" />

    <script type="text/javascript" src="/js/jquery/jquery-1.12.4.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery-ui-1.12.0.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.easing.1.3.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.bxslider.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.mCustomScrollbar.concat.min.js?v=2023051202"></script>
    <!-- block ui -->
    <script type="text/javascript" src="/js/jquery/jquery.blockUI.min.js?v=2023051202"></script>

    <script type="text/javascript" src="/js/jquery/TweenMax.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.cookie.js?v=2023051202"></script>
    <!--<script type="text/javascript" th:src="'/js/lottie.js?v=' + ${cacheParam}"></script>-->
    <script type="text/javascript" src="/js/ui.common.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/subway.common.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/util/jsrender.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/jquery/jquery.tmpl.min.js?v=2023051202"></script>
    <script type="text/javascript" src="/js/waffle/waffle.utils.js?v=2023051202"></script>
<style>
    /* 목록 스타일 변경 */
    ul {
        list-style-type: none; /* 목록 기호 제거 */
        padding: 0; /* 내부 여백 제거 */
    }
</style>
</head>
<body>
<%@ include file="../include/header.jsp"%>
	<div id="container">
		<form action="update_view" method="post">
			<table cellpadding="0" cellspacing="0" border="1">
				<tr>
					<td><input type="hidden" name="boardID"
						value="${content_view.boardID}"></td>
				</tr>
				<tr>
					<td>번호</td>
					<td>${content_view.boardID}</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${content_view.bmID}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="boTitle"
						value="${content_view.boTitle}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>작성내용</td>
					<td><textarea name="boContent" rows="20" cols="100" readonly="readonly">${content_view.boContent}</textarea></td>
				</tr>
				<c:if test="${userId == content_view.bmID}">
					<tr>
						<td colspan="2"><input type="submit" value="수정하기">
							&nbsp;&nbsp;</td>
					</tr>
				</c:if>
			</table>

		</form>
		<c:forEach items="${comment_view }" var="dtos">
			<ul>
				<li><c:forEach begin="1" end="${dtos.commentlevel }">
					&nbsp;&nbsp;&nbsp;
				</c:forEach> -> id : ${dtos.commentuserid } 
				date :${dtos.commentdate } <br> 
				<c:forEach begin="1" end="${dtos.commentlevel }">
					&nbsp;&nbsp;&nbsp;
				</c:forEach> 
					<c:choose>
						<c:when test="${dtos.commentdelete == 1 }">
				&nbsp;&nbsp;&nbsp;<b style="color: rgba(128, 128, 128, 0.5);">삭제된 메세지 입니다.</b>
						</c:when>
						<c:when test="${dtos.commentdelete == 0}">
				&nbsp;&nbsp;&nbsp;${dtos.commentcontent } 
				<button onclick="showReplyForm(${dtos.commentid})">답글</button>
							<c:if test="${userId == dtos.commentuserid}">
								<tr>
									<td colspan="2">
										<button onclick="showReplyUpdateForm(${dtos.commentid})">수정</button>
										&nbsp;&nbsp; <a
										href="/commentdelete?commentId=${dtos.commentid}&postId=${content_view.boardID}">삭제</a>
										&nbsp;&nbsp;
									</td>
								</tr>
							</c:if>
						</c:when>
					</c:choose>
					<form id="replyForm${dtos.commentid}" action="reply" method="post"
						style="display: none;">
						<input type="hidden" name="boardID"
							value="${content_view.boardID}"> <input type="hidden"
							name="postId" value="${content_view.boardID}"> <input
							type="hidden" name="commentGroup" value="${dtos.commentgroup}">
						<input type="hidden" name="commentId" value="${dtos.commentid}">
						<input type="hidden" name="commentLevel"
							value="${dtos.commentlevel}">
						<textarea name="commentContent" rows="2" cols="50"
							placeholder="답글을 작성해 주세요."></textarea>
						<input type="submit" value="답글 작성">
					</form>
					<form id="replyUpdateForm${dtos.commentid}" action="replyUpdate"
						method="post" style="display: none;">
						<input type="hidden" name="commentId" value="${dtos.commentid}">
						<textarea name="commentContent" rows="2" cols="50"
							placeholder="답글을 수정해 주세요.">${dtos.commentcontent }</textarea>
						<input type="hidden" name="postId" value="${content_view.boardID}">
						<input type="submit" value="답글 수정">
					</form></li>
			</ul>
		</c:forEach>
		<form action="comment" method="post">
			<input type="hidden" name="postId" value="${content_view.boardID}">
			<input type="hidden" name="commentId" value="${dtos.commentid}">
			<input type="hidden" name="commentGroup" value="${comment_group}">
			<textarea name="commentContent" rows="2" cols="50" placeholder="댓글을 작성해 주세요."></textarea>
			<input type="submit" value="댓글 작성">
		</form>
	</div>
	<a href="board">목록보기</a>
	<br><br><br>
	<%@ include file="../include/footer.jsp"%>
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