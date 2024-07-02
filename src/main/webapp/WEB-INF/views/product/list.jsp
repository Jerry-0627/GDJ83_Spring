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
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

	<table class = "table table-striped table-primary">
		<thead>
			<h1>금융 상품</h1>
			<tr>
				<th>상품 번호</th>
				<th>상품 이름</th>
				<th>상품 이자율</th>
				<th>상품 설명</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${list}" var = "dto"> 
				<tr>
					<td>${dto.product_Num}</td>
					<td><a href="./detail?product_Num=${dto.product_Num}">${dto.product_Name}</a></td>
					<td>${dto.product_Rate}</td>
					<td>${dto.product_Ex}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
			<a href="./add" class = "btn btn-outline-primary">금융상품 등록</a>
	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>