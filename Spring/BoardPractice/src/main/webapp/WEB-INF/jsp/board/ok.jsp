<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판 작업</title>
	</head>
	<body>
		<table>
			<tr>
				<th>번호</th><td>${dto.no}</td>
			</tr>
			<tr>
				<th>제목</th><td>${dto.title}</td>
			</tr>
			<tr>
				<th>작성자</th><td>${dto.writer}</td>
			</tr>
		</table>
		메시지 : ${msg}
		<hr>
		<a href = "board_insert">게시물 등록</a><br>
		<a href = "board_list">게시물 목록</a><br>
	</body>
</html>