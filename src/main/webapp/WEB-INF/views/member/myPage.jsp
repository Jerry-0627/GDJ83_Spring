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
	<div class = "container">
		<h1>회원 정보 확인 페이지</h1>
		<div class="mb-3">
			<label for="user_name" class="form-label">회원 이름</label>
			<input type="text" class="form-control" id="user_name" name = "user_name" value="${member.user_name}" disabled>
		</div>
		<div class="mb-3">
			<label for="user_phone_num" class="user_phone_num">회원 전화번호</label>
			<input type="text" class="form-control" id="user_phone_num" name = "user_phone_num" value="${member.user_phone_num}" disabled>
		</div>
		<div class="mb-3">
			<label for="user_email" class="form-label">회원 이메일</label>
			<input type="email" class="form-control" id="user_email" name = "user_email" value="${member.user_email}" disabled>
		</div>
			<div class="mb-3">
			<label for="user_address" class="form-label">회원 주소</label>
			<input type="text" class="form-control" id="user_address" name = "user_address"  value="${member.user_address}" disabled>
		</div>
		<div>
			<h3>계좌정보</h3>
			<c:forEach items="${member.dtos}" var = "ac">
				<h3><a href="../account/detail?account_num=${ac.account_num}">${ac.account_num}</a> : ${ac.balance}</h3>
			</c:forEach>
		</div>
		<div>
			<a type = "button" href = "./update" class="btn btn-primary">회원 정보 수정</a>
			<a type = "button" href = "/" class="btn btn-danger">홈으로 돌아가기</a>
			<form action="./delete">
				<button class="btn btn-warning">회원 탈퇴</button>
			</form>
		</div>
	</div>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>