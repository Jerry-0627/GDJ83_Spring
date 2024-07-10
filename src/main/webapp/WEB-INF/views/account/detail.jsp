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

<!--계좌번호, 상품 번호, 회원 아이디, 잔액, 계좌 날자, 상품 이름, 상품 이자-->
	<div class="container">
	<h1>계좌 정보</h1>
		<h3>상품명 : ${detail.productDTO.product_name}</h3>
		<h3>계좌 번호 : ${detail.account_num}</h3>
		<h3>잔액 : ${detail.balance}</h3>
		<h3>개설일 : ${detail.account_date}</h3>
		<h3>이자율 : ${detail.productDTO.product_rate}</h3>
	<a href="./transfer?account_num=${detail.account_num}" type = "button"	class="btn btn-primary">송금</a>
	<a href="./list?account_num=${detail.account_num}&order=0" type = "button"	class="btn btn-primary">거래 내역 조회</a>
	</div>
	
	
	
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import> 
</body>
</html>