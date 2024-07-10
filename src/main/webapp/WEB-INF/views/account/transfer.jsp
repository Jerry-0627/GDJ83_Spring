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
	<div class="container">	
		<h1>트렌스퍼</h1>
		<form action="./transfer" method = "post">
			<div class="mb-3">
				<label for="receive_num" class="form-label">계좌 번호</label>
				<input type="text" class="form-control" id="receive_num" name = "receive_num">
			</div>
			<div class="mb-3">
				<label for="trade_amount" class="form-label">이체 금액</label>
				<input type="text" class="form-control" id="trade_amount" name = "trade_amount">
			</div>
			<div class="mb-3">
				<input type="hidden" class="form-control" id="account_num" name = "account_num" value="${param.account_num}">
			</div>
			<button type = "submit" class = "btn btn-primary">송금</button>
		</form>
	</div>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import> 
</body>
</html>