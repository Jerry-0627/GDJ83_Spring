<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>상품 등록 페이지</h1>
		</div>
		<div class = "row">
			<form action="./add" method="post">
				<div class="mb-3">
				 	<label for="board_title" class="form-label"></label>
				  	<input type="text" class="form-control" id="board_title" name = "board_title">
				</div>
				<div class="mb-3">
				 	<label for="product_rate" class="form-label">상품 이자율</label>
				  	<input type="text" class="form-control" id="product_rate" name = "product_rate">
				</div>
							<div class="mb-3">
				 	<label for="product_ex" class="form-label">상품 설명</label>
				  	<input type="text" class="form-control" id="product_ex" name = "product_ex">
				</div>
				
				
				<button type = "submit" class = "btn btn-primary">등록</button>
				<a href="./list" class = "btn btn-outline-danger">취소</a>
				
			</form>	
		</div>
		
	</div>

</body>
</html>