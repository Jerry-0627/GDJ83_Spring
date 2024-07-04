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
			<h1>금융상품 추가 페이지</h1>
		</div>
		<div class = "row">
			<form action="./add" method="post">
				<div class="mb-3">
					<label for="Product_Num" class="form-label">상품 번호</label>
				  	<input type="text" class="form-control" id="Product_Num" name = "Product_num"  placeholder = "자동으로 입력됨" disabled>
				</div>
				<div class="mb-3">
					<label for="Product_Name" class="form-label">상품 이름</label>
				  	<input type="text" class="form-control" id="Product_Name" name = "Product_name">
				</div>
				<div class="mb-3">
				 	<label for="Product_Rate" class="form-label">상품 이자율</label>
				  	<input type="text" class="form-control" id="Product_Rate" name = "Product_rate">
				</div>
				<div class="mb-3">
				 	<label for="Product_Ex" class="form-label">상품 설명</label>
				  	<input type="text" class="form-control" id="Product_Ex" name = "Product_ex">
				</div>
				<div>
					<button type = "submit" class =  "btn btn-outline-primary">등록</button>
					<a href="./list" class = "btn btn-outline-danger">취소</a>
				</div>
			</form>	
		</div>
	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>