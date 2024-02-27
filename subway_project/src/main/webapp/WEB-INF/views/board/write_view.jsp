<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록 작성</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write" method="post">
			<tr>
				<td> 작성자 </td>
				<td><input type="text" name="bmID" size = "50" value="${userId}" readonly="readonly"> </td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="boTitle" size = "50"> </td>
			</tr>					
			<tr >
						
				<td> 작성내용 </td>
				<td> <input type="text" name="boContent" size = "50"> </td>
			</tr>			
			<tr >
				<td colspan="2"> <input type="submit" value="입력"> &nbsp;&nbsp; <a href="/board/list">목록보기</a></td>
			</tr>
		</form>
	</table>


</body>
</html>