<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file ="/WEB-INF/jsp/include/header_admin.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체목록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<style>
	#container { width: 700px; margin: auto; }
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	table {text-align: center;}
	th { background-color: orange; }
	.center { text-align: center; }
	
	.border-none, .border-none td { border: none; }
</style>
</head>
<body>

<div id="container">
	<h1>공지사항</h1>	
	<!-- 검색을 위한 폼 -->
	<form action="getNoticeBoardList" method="get">
		<table class="border-none">
			<tr>
				<td>
					<select name="searchCondition">
					<c:forEach var="option" items="${conditionMap }">
						<option value="${option.value }">${option.key }</option>
					</c:forEach>
					</select>
					<input type="text" name="searchKeyword">
					<input type="submit" value="검색">
				</td>
			</tr>
		</table>
	</form>
	
	<!-- 데이터 표시 영역 -->
	<table>
		<thead>
			<tr>
				<th width="100">번호</th>
				<th width="200">제목</th>
				<th width="150">작성일</th>
				<th width="150">조회수</th>
				<th width="70">관리</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="board" items="${NoticeboardList }">
			<tr>
				<td>${board.boardIdx }</td>
				<td>
					<a href="get_notice_board?boardIdx=${board.boardIdx }">${board.title }</a>
				</td>
				<td>${board.regDate }</td>
				<td>${board.hit }</td>
				<td><a href="delete_notice_board?boardIdx=${board.boardIdx }">삭제</a></td>
			</tr>
		</c:forEach>
		<c:if test="${empty NoticeboardList }">
			<tr>
				<td colspan="5" class="center">공지사항이 없습니다</td>
			</tr>
		</c:if>
		</tbody>
	</table>
	
	<p><a href="insert_board_view">새글등록</a></p>
</div>

</body>
<%@ include file="/WEB-INF/jsp/include/include-footer.jspf"%>
</html>