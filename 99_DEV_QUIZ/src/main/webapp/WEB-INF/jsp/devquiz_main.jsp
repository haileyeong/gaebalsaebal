<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file ="../jsp/include/header_admin.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여기가 메인</title>
<script>
	function goGame() {
		location.href="go_game";
	}
</script>
</head>
<body>
	<h1>메인화면될곳입니다.......</h1>
	<button onclick="goGame()">게임 실행 고고</button>
</body>
</html>
