<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file ="/WEB-INF/jsp/include/header_af.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임 실행하기!</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css"> 
<script>
	function game_303() {
		console.log("됨");
		alert("됨"); // 오타 수정
		//location.href="game_sql";
	}
	function game_302() {
		console.log("302");
		alert("302"); // 오타 수정
		//location.href="game_sql";
	}
</script>
<style>
.gameBody { /* 전체 페이지 이거 쓰면 되겠답 */
	    height: auto; /* 또는 원하는 높이 */
	   	margin: 0 auto;
	    background: #DDA0DD; /* .gameBody의 배경색 */
	    position: relative; /* 상대 위치 설정 */
	    
		border: 1px solid red;
		width: 60%;
		margin: 0 auto;
	}
	
 	button {
		border: none;         /* 테두리 제거 */
	    background: none;     /* 배경 제거 */
	    padding: 0;           /* 내부 간격 제거 */
	    margin: 0;            /* 외부 여백 제거 */
	    outline: none;        /* 포커스 표시 제거 */
	    text-decoration: none; /* 텍스트 밑줄 제거 */
	    box-shadow: none;     /* 그림자 제거 */
	} 
.games button {
	 /* 원하는 스타일 설정 */
	    cursor: pointer;
	 	border : 1px solid black;
	    background: black;
	    color: white;
	    border-radius: 50%;
	    width: 200px;
	    height: 200px;
	    margin: 0 30px 0 30px;
	    text-align: center; /* 가운데 정렬을 위한 스타일 추가 */
}
</style>

</head>
<body>

    <!-- 게임 선택 -->
    <div class="gameBody">
    	<div class="games">
		<c:forEach var="quizCate" items="${quizCate }">
			<button onclick="game_${quizCate.cateIdx}()" id="btnGame">${quizCate.cateName}</button>
		</c:forEach>
		</div>
    		
    </div>
    	
    
	\${quizCate } : ${quizCate }
	<div id="container">
		<h1>게임 실행 [game_main.jsp]</h1>
			<p><a href="devquiz_main">메인화면 가기</a></p>
			
	    <!-- 데이터 꺼내쓰기 연습 -->
		<div>
			<c:forEach var="quizCate" items="${quizCate }">
			${quizCate.cateName }
			</c:forEach>
			<hr>
		   ${quizCate[1].cateName}
		 </div>
	</div>
	
	<hr>
<%@ include file="/WEB-INF/jsp/include/include-footer.jspf"%>
</body>
</html>

	
	<%-- <form action="gameInsert" method="post" enctype="multipart/form-data">
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
</div> --%>
</html>