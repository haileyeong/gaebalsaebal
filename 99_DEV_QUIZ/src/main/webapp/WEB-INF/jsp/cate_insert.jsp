<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../jsp/include/header_admin.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 추가해보자</title>
</head>
<body>
<div id="conainer">
	<p><a href="/devquiz/devquiz_main">메인으로가기!</a></p>
	
	<form action="/devquiz/cate_insert" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>추가 도메인</th>
				<td>
					<select name="cateType">
						<option value="board">게시글</option>
						<option value="game">게임</option>
						<option value="prods">상품</option>
						<option value="question">문의</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>카테고리이름 (중복안됨다)</th>
				<td>
					<input type="text" name="cateName">
				</td>
			</tr>
			<tr>
				<td colspan="2" class="center">
					<input type="submit" value="카테고리 추가">
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>

