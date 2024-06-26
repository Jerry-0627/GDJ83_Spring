<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<h1>부서 리스트</h1>
	
	<div>
		<div>
			<a href="./add" class = "btn btn-outline-success">부서등록</a>
		</div>
		<table Class="table table-dark table-hover">
			<thead>
				<tr>
					<th>부서번호</th>
					<th>부서명</th>
					<th>관리자</th>
					<th>지역</th>
				</tr>
			</thead>
			
			<tbody>
			<%-- ${스코프명.영역} 스코프명 생략 가능 --%> 
				<c:forEach items="${list}" var="dto">
				<!-- dto에는 list에서 하나 꺼낸 것이 담겨 있다. 즉, DepartmentDTO 타입..이 담겨 있다 -->
					<tr>
					<!-- get 뺴고 세터게터 첫번째 문자를 소문자.. -->
						<td>${dto.department_id}</td>
						<%-- <td><a href = "./detail}">${dto.department_name}</a></td> --%>
						<td><a href = "./detail?department_id=${dto.department_id}">${dto.department_name}</a></td>
						<!-- href = "detail" 으로 써도됨. ./ 는 생략 가능 -->
						<td>${dto.manager_id}</td>
						<td>${dto.location_id}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		
	</div>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>