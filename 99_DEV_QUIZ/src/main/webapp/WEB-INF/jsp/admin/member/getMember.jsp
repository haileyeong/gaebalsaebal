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
	<h1>회원정보 상세</h1>
		<input type="hidden" name="memberIdx" value="${member.memberIdx }">
		<table>
			<tr>
				<th>아이디</th>
				<td>${member.id }</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${member.name }</td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${member.nickname }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>${member.email }</td>
			</tr>
			<tr>
				<th>휴대폰 번호</th>
				<td>${member.phone }</td>
			</tr>
			<tr>
				<th>포인트</th>
				<td>${member.point }</td>
			</tr>
			<tr>
				<th>작성한 게시글 수</th>
				<td><!-- 여기부터 수정 -->
					<a href="get_member?memberIdx=${member.memberIdx }">${member.id }</a>
				</td>
			</tr>
			<tr>
				<th>가입 날짜</th>
				<td>${member.joinDate }</td>
			</tr>
			<tr>
				<th>가입 상태</th>
				<td>
					<c:if test = "${member.isDel ==0}">
					회원
					</c:if>
					<c:if test = "${member.isDel ==1}">
					탈퇴 회원
					</c:if>
				</td>
			</tr>
			<tr>
				<th>권한</th>
				<td>
					<c:if test = "${member.isAdmin ==0}">
					회원
					</c:if>
					<c:if test = "${member.isAdmin ==1}">
					관리자
					</c:if>
				</td>
			</tr>
		</table>
	<p>
		<a href="delete_member?memberIdx=${member.memberIdx }">회원삭제</a>
		<a href="get_member_list">회원목록</a>
	</p>
	
</div>

</body>
<%@ include file="/WEB-INF/jsp/include/include-footer.jspf"%>
</html>