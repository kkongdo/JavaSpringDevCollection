<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시물 삭제</title>
		<style>
			table,th, td{
				border: 1px solid black;
			}
		</style>
	</head>
	<body>
		<h1>게시물 삭제</h1>
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
			<tr>
				<th>작성일</th><td>${dto.regdate}</td>
			</tr>
			<tr>
				<th>내용</th>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="3" cols="40">${dto.content}</textarea></td>
			</tr>
			</table>
		<a href="list">목록</a>
		<a href = "board_delete_action?no=${dto.no}">게시물 삭제</a><br>
	</body>
</html>