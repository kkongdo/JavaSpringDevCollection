<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시물 삭제폼</title>
	</head>
	<body>
		<h1>게시물 삭제</h1>
		<table>
			<tr>
				<th>번호</th><td>${dto.no }</td>
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
		<a href="delete_action?no=${dto.no}">삭제</a>
	</body>
</html>