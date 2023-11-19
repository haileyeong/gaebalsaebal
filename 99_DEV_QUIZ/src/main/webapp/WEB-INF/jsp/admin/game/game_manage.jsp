<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file ="/WEB-INF/jsp/include/header_admin.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 추가하기!</title>
</head>
<body>
\${cate } : ${cate }
<div id="conainer">
	<h1>게임 관리 [game_manage.jsp]</h1>
	<p><a href="devquiz_main">메인화면 가기</a></p>
	
	<form action="gameInsert" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>게임 카테고리</th>
				<td>
					<select name="cateIdx">
					<c:forEach var="cate" items="${cate }">
						<option value="${cate.cateIdx}" }>${cate.cateName }</option>
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>문제</th>
				<td>
					<input type="text" name="quiz">
				</td>
			</tr>
 			<tr>
				<th>적립 포인트</th>
				<td>
					<select>
						<option value=savedPoint>10</option>
					</select>
				</td>
			</tr>
			<tr>
				<th width="70">점수</th>
				<td>
					<input type="text" value="savedScore">
				</td>
			</tr>
			<tr>
				<th width="70">보기 1</th>
				<td>
					<textarea rows="5" cols="30" name="exampleNo1"></textarea>
				</td>
			</tr>
			<tr>
				<th width="70">보기 2</th>
				<td>
					<textarea rows="5" cols="30" name="exampleNo2"></textarea>
				</td>
			</tr>
			<tr>
				<th width="70">보기 3</th>
				<td>
					<textarea rows="5" cols="30" name="exampleNo3"></textarea>
				</td>
			</tr>
			<tr>
				<th width="70">보기 4</th>
				<td>
					<textarea rows="5" cols="30" name="exampleNo4"></textarea>
				</td>
			</tr>
			<tr>
				<th width="70">보기 5</th>
				<td>
					<textarea rows="5" cols="30" name="exampleNo5"></textarea>
				</td>
			</tr>
			<tr>
				<th width="70">정답</th>
				<td>
					<textarea rows="5" cols="30" name="answer"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="center">
					<input type="submit" value="문제 등록">
				</td>
			</tr>
		</table>
	</form>
	<p>
		<a href="#">글 목록 가기</a>
	</p>
</div>
</html>





