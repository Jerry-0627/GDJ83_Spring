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
	<table class = "table">
			<h1>거래 내역 조회</h1>
			<div>
				<a type="button" class="btn btn-light" href="list?account_num=${param.account_num}&order=1">과거순으로</a>
				<a type="button" class="btn btn-light" href="list?account_num=${param.account_num}&order=0">최신순으로</a>
				<a type="button" class="btn btn-light" href="list?account_num=${param.account_num}&order=0&trade_type=입금">입금만 조회</a>
				<a type="button" class="btn btn-light" href="list?account_num=${param.account_num}&order=0&trade_type=출금">출금만 조회</a>
				<a type="button" class="btn btn-light" href="list?account_num=${param.account_num}&order=0">입출금 조회</a>
			</div>
		<thead>
			<tr>
				<th>Trade Date</th>
				<th>Trade TYPE</th>
				<th>Trade Amount</th>
				<th>Balance</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${list}" var = "dto"> 
				<tr>
					<td>${dto.trade_date}</td>
					<td class=${dto.trade_type.equals("입금")?'text-primary':'text-danger'}>
						${dto.trade_type}
					</td>
					<td class=${dto.trade_type.equals("입금")?'text-primary':'text-danger'}>
						${dto.trade_amount}
					</td>
					<td>${dto.balance}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import> 
	
</body>
</html>