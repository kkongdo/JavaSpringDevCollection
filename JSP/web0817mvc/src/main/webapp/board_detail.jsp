<%@page import="web0817mvc.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	BoardDto dto = (BoardDto)request.getAttribute("dto");
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상세보기</title>
	</head>
	<body>
		<h1>상세보기</h1>
		<table>
			<tr>
				<th>번호</th>	<td>${dto.no}</td>		
			</tr>
			<tr>
				<th>제목</th><td>	${dto.title}</td>	
			</tr>
			<tr>
				<th>작성자</th><td>${dto.writer}</td>	
			</tr>
			<tr>
				<th>작성일</th><td>${dto.regdate}</td>	
			</tr>
			<tr>
				<th colspan="2">내용</th>
			</tr>
			<tr>
				<td colspan="2"><textarea rows="3" cols="40">${dto.content}</textarea></td>
			</tr>
		</table>
		<a href="list">목록</a>
		<a href="update_form?no=${dto.no}">수정</a>
		<!-- 수정폼은 검색한 dto의 각 변수를 등록폼에 출력시킨다. -->
		<!--  수정폼은 상세보기 + 등록폼 -->
		<a href="delete_form?no=${dto.no}">삭제</a>
	</body>
</html>