<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시물 등록 폼 화면</title>
	</head>
	<body>
		<h1>게시물 등록</h1>
		<form action="insert_action" method = "post">
			게시물 제목 : <input type ="text" name = "title"><br>
			게시물 작성자 : <input name = "writer"><br>
			게시물 내용
			<textarea rows ="3" cols = "60" name = "content"></textarea>
			<br>
			<input type = "submit" value = "게시물 등록">
		</form>
	</body>
</html>