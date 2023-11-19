<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file ="/WEB-INF/jsp/include/header_admin.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<style>
	#container { width: 700px; margin: auto; }
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: orange;
	text-align: center;
	width: 130px; }
	.center { text-align: center; }
	
	.border-none, .border-none td { border: none; }
</style>
</head>
<body>
<div id="container">
	<h1>글상세</h1>
		<input type="hidden" name="boardIdx" value="${board.boardIdx }">
		<input type="hidden" name="memberIdx" value="${board.memberIdx }">
		<table>
			<tr>
				<th>제목</th>
				<td>${board.title }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${nickname }</td>
			</tr>
			<tr>
				<th>카테고리</th>
				<td>${category }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td height="150px">${board.content }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${board.regDate }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${board.hit }</td>
			</tr>
		</table>
	<p>
		<a href="delete_board?boardIdx=${board.boardIdx }">글삭제</a>
		<a href="get_board_list">글목록</a>
	</p>
	
</div>

</body>
<%@ include file="/WEB-INF/jsp/include/include-footer.jspf"%>
</html>