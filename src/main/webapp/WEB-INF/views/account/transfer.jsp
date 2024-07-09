<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>트렌스퍼</h1>
	<form action="./transfer" method = "post">
		<div class="mb-3">
			<label for="account_num" class="form-label">계좌 번호</label>
			<input type="text" class="form-control" id="account_num" name = "account_num_you">
		</div>
		<div class="mb-3">
			<label for="trade_amount" class="form-label">이체 금액</label>
			<input type="text" class="form-control" id="trade_amount" name = "trade_amount">
		</div>
		<div class="mb-3">
			<input type="hidden" class="form-control" id="account_num" name = "account_num_me" value="${detail.account_num}">
		</div>
		<div class="mb-3">
			<input type="hidden" class="form-control" id="account_num" name = "balance" value="${detail.balance}">
		</div>
		
		<button type = "submit" class = "btn btn-primary">송금</button>
	</form>
</body>
</html>