<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>금융상품 추가 페이지</h1>
		</div>
		<div class = "row">
			<form action="./add" method="post">
				<div class="mb-3">
				 	<label for="department_name" class="form-label">상품 번호</label>
				  	<input type="text" class="form-control" id="department_name" name = "department_name">
				</div>
				<div class="mb-3">
					<label for="manager_id" class="form-label">상품 이름</label>
				  	<input type="text" class="form-control" id="manager_id" name = "manager_id">
				</div>
				<div class="mb-3">
				 	<label for="location_id" class="form-label">상품 이자율</label>
				  	<input type="text" class="form-control" id="location_id" name = "location_id">
				</div>
				<div class="mb-3">
				 	<label for="location_id" class="form-label">상품 설명</label>
				  	<input type="text" class="form-control" id="location_id" name = "location_id">
				</div>
				<button type = "submit" class = "btn btn-primary">추가</button>
				<a >a</a>
			</form>	
		</div>
	</div>
</body>
</html>