<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>지역 추가</h1>
			<form action="./add" method = "post">
				<div class="mb-3">
				 	 <label for="street_address" class="form-label">거리 주소</label>
				  	<input type="text" class="form-control" id="street_address" name="street_address">
				</div>
				<div class="mb-3">
				 	 <label for="postal_code" class="form-label">우편 번호</label>
				  	<input type="text" class="form-control" id="postal_code" name="postal_code">
				</div>
				<div class="mb-3">
				 	 <label for="city" class="form-label">도시명</label>
				  	<input type="text" class="form-control" id="city" name="city">
				</div>
				<div class="mb-3">
				 	 <label for="state_province" class="form-label">지역</label>
				  	<input type="text" class="form-control" id="state_province" name="state_province">
				</div>
				<div class="mb-3">
				 	 <label for="country_id" class="form-label">나라 ID</label>
				  	<input type="text" class="form-control" id="country_id" name="country_id">
				</div>
				<button type = "submit" class = "btn btn-primary">등록</button>
			</form>
	</div>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>