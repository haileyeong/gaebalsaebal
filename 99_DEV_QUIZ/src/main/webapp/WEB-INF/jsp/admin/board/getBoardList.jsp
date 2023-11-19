<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/jsp/include/header_admin.jspf" %>
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
	<!-- 검색을 위한 폼 -->
	<form action="get_board_list" method="get">
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
				<th width="50">번호</th>
				<th width="100">카테고리</th>
				<th width="250">제목</th>
				<th width="100">작성자</th>
				<th width="150">작성일</th>
				<th width="100">조회수</th>
				<th width="70">관리자</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="board" items="${boardList }">
			<tr>
				<td>${board.boardIdx }</td>
				<td>${board.cateIdx }</td>
				<td>
					<a href="get_board?boardIdx=${board.boardIdx }">${board.title }</a>
				</td>
				<td>${nickname }</td>
				<td>${board.regDate }</td>
				<td>${board.hit }</td>
				<td><a href="delete_board?boardIdx=${board.boardIdx }">삭제</a></td>
			</tr>
		</c:forEach>
		<c:if test="${empty boardList }">
			<tr>
				<td colspan="6" class="center">커뮤니티 게시글이 없습니다</td>
			</tr>
		</c:if>
		</tbody>
	</table>
	
</div>

</body>
<%@ include file="/WEB-INF/jsp/include/include-footer.jspf"%>
</html>