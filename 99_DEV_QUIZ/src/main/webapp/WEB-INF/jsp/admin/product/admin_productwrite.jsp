<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/header_admin.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품등록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <style>
        .product {
            margin-bottom: 20px;
        }

        .product label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .product .product-pro {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        .button {
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

    </style>
</head>
<body>
    <div class="container" style="max-width: 700px; margin: 0 auto;">
        <h3>상품등록</h3>
        <form action="/admin_productwrite" method="post" enctype="multipart/form-data">
            <div class="product">
                <label for="category">카테고리</label>
                <select class="product-pro" name="cateName">
                    <option value="Frontend">Frontend</option>
                    <option value="Backend">Backend</option>
                </select>
            </div>

            <div class="product">
                <label for="productName">상품명</label>
                <input class="product-pro" type="text" name="productName" title="상품명" placeholder="productName">
            </div>

            <div class="product">
                <label for="productPrice">가격</label>
                <input class="product-pro" type="text" name="productPrice" title="가격" placeholder="productPrice">
            </div>

            <div class="product">
                <label for="uploadFile">이미지</label>
                <input class="product-pro" type="file" title="이미지" name="uploadFile" id="formFile">
            </div>

            <div class="product">
                <label for="productContent">상품정보</label>
                <textarea class="product-pro" name="productContent" title="상품정보" rows="15"></textarea>
            </div>

            <input class="button" type="submit" value="등록하기" title="등록하기" />
            <input class="button" type="reset" value="다시입력" title="다시입력" />
            <input class="button" type="button" value="작성취소" title="작성취소" onclick="location.href='/devquiz/admin_product'" />
        </form>
    </div>
</body>
<%@ include file="/WEB-INF/jsp/include/include-footer.jspf"%>
</html>
