<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file ="/WEB-INF/jsp/include/header_admin.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원전체목록</title>
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
	<form action="get_member_list" method="get">
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
				<th width="200">아이디</th>
				<th width="150">이름</th>
				<th width="100">포인트</th>
				<th width="100">가입상태</th>
				<th width="100">권한</th>
				<th width="100">관리자</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="member" items="${memberList }">
			<tr>
				<td>${member.memberIdx }</td>
				<td>
					<a href="get_member?memberIdx=${member.memberIdx }">${member.id }</a>
				</td>
				<td>${member.name }</td>
				<td>${member.point }</td>
				<td>
					<c:if test = "${member.isDel ==0}">
					회원
					</c:if>
					<c:if test = "${member.isDel ==1}">
					탈퇴 회원
					</c:if>
				</td>
				<td>
					<c:if test = "${member.isAdmin ==0}">
					회원
					</c:if>
					<c:if test = "${member.isAdmin ==1}">
					관리자
					</c:if>
				</td>
				<td><a href="delete_member?memberIdx=${member.memberIdx }">삭제</a></td>
			</tr>
		</c:forEach>
		<c:if test="${empty memberList }">
			<tr>
				<td colspan="9" class="center">등록된 회원이 없습니다</td>
			</tr>
		</c:if>
		</tbody>
	</table>
	
</div>

</body>
<%@ include file="/WEB-INF/jsp/include/include-footer.jspf"%>
</html>