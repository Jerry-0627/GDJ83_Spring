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

<!--계좌번호, 상품 번호, 회원 아이디, 잔액, 계좌 날자, 상품 이름, 상품 이자-->
	<h1>하이</h1>
	<h1>${requestScope.member.product_num}</h1>

	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import> 
</body>
</html>