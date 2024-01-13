<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MVC 예제</title>
	</head>
	<body>
		<h1>Welcome MVC</h1>
		<a href = "board/insert_form">게시물 등록</a><br> <!-- 상대경로(board/insert_form)은 실행시 board앞에\ 현재 URL의 경로가 붙는다 --> <!-- 절대경로는 /web0817mvc/가 board앞에 붙어야한다 -->
		<a href = "board/list">게시물 목록</a>
		
	</body>
</html>