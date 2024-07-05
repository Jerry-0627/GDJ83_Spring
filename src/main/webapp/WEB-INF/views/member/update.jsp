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
		<h1>회원 정보 수정 페이지</h1>
			<div class = "row">
				<form action="./update" method="post">

					<div class="mb-3">
					 	<label for="user_name" class="form-label">회원 이름</label>
					  	<input type="text" class="form-control" id="user_name" name = "user_name" value="${sessionScope.member.user_name}">
					</div>
					<div class="mb-3">
					 	<label for="user_phone_num" class="user_phone_num">회원 전화번호</label>
					  	<input type="text" class="form-control" id="user_phone_num" name = "user_phone_num" value="${sessionScope.member.user_phone_num}">
					</div>
					<div class="mb-3">
					 	<label for="user_email" class="form-label">회원 이메일</label>
					  	<input type="email" class="form-control" id="user_email" name = "user_email" value="${sessionScope.member.user_email}">
					</div>
					<div class="mb-3">
					 	<label for="user_address" class="form-label">회원 주소</label>
					  	<input type="text" class="form-control" id="user_address" name = "user_address"  value="${sessionScope.member.user_address}">
					</div>
					<button class = "btn btn-primary">등록</button>
					<a href="./myPage" class = "btn btn-outline-danger">취소</a>
					
				</form>	
			</div>
	</div>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>	
</body>
</html>