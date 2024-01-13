<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			table, tr, th, td{
				border: 1px solid black
			}
			
		</style>
	</head>
	<body>
		<h1>상세보기</h1>
		<table>
			<tr>
				<th>게시물 번호</th><td>${dto.no}</td>
			</tr>
			<tr>
				<th>게시물 제목 </th><td>${dto.title}</td>
			</tr>
			<tr>
				<th>게시물 작성자</th><td>${dto.writer}</td>
			</tr>
			<tr>
				<th>게시물 내용</th>
			</tr>
			<tr>
				<td colspan= "2"><textarea rows = "3" cols = "60">${dto.content}</textarea></td>
			</tr>
			<tr>
				<th>게시물 날짜</th><td>${dto.regdate}</td>
			</tr>
		</table>
		<hr>
		<a href = "board_update?no=${dto.no}">게시물 수정</a><br>
		<a href = "board_delete?no=${dto.no}">게시물 삭제</a><br>
		<a href = "board_list">게시물 목록</a>
	</body>
</html>