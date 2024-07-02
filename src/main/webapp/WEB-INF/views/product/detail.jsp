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
			<h1>${detail.product_Name} 상세 정보</h1>
		
			<tr>
				<th>상품 번호</th>
				<th>상품 이름</th>
				<th>상품 이자율</th>
				<th>상품 설명</th>
			</tr>
		</thead>
		<tbody>
			<td>${detail.product_Num }</td>
			<td>${detail.product_Name }</td>
			<td>${detail.product_Rate }</td>
			<td>${detail.product_Ex }</td>
		</tbody>
	</table>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>	
</body>
</html>