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
			<h1>${detail.product_name}의 상세 정보</h1>
		
			<tr>
				<th>상품 번호</th>
				<th>상품 이름</th>
				<th>상품 이자율</th>
				<th>상품 설명</th>
			</tr>
		</thead>
		<tbody>
			<td>${detail.product_num }</td>
			<td>${detail.product_name }</td>
			<td>${detail.product_rate }</td>
			<td>${detail.product_ex }</td>
		</tbody>
	</table>
	<div>
		<a href="../account/add" class = "btn btn-outline-primary">상품 가입</a>
		<a href="./update?product_num=${detail.product_num}" class = "btn btn-outline-warning">상품 수정</a>
		<a href="./delete?product_num=${detail.product_num}" class = "btn btn-outline-danger">상품 삭제</a>
	</div>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>	
</body>
</html>