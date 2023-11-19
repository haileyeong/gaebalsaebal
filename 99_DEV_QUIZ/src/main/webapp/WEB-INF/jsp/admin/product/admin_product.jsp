<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header_admin.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품목록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">    
</head>
<body>
    <div id="container">
        <h2>상품 목록</h2>
        <table class="product-table">
            <thead>
                <tr>
                    <th>상품 번호</th>
                    <th>상품 이름</th>
                    <th>가격</th>
                    <th>설명</th>
                    <th>이미지</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td>${product.productIdx}</td>
                        <td>${product.productName}</td>
                        <td>${product.productPrice}</td>
                        <td>${product.productContent}</td>
                        <td><img src="${pageContext.request.contextPath}/resources/images/${product.productFile}" alt="${product.productName}"></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="${pageContext.request.contextPath}/admin_productwrite" class="add-button">상품 등록</a>
    </div>
</body>
<%@ include file="/WEB-INF/jsp/include/include-footer.jspf"%>
</html>
