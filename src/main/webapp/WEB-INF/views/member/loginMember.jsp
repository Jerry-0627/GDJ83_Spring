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
		<h1>맴버 로그인</h1>
			<div class = "row">
				<form action="/member/loginMember" method="post">
					<div class="mb-3">
					 	<label for="user_id" class="form-label">회원 아이디</label>
					  	<input type="text" class="form-control" value= "${id}" id="user_id" name = "user_id">
					</div>
					<div class="mb-3">
					 	<label for="user_pw" class="form-label">회원 비밀번호</label>
					  	<input type="password" class="form-control" id="user_pw" name = "user_pw">
					</div>
					<div class="mb-3 form-check">
    					<input type="checkbox" name="remember" class="form-check-input" id="exampleCheck1">
   						 <label class="form-check-label" for="exampleCheck1">ID 기억하기</label>
  					</div>
					<button type = "submit" class = "btn btn-primary">로그인</button>
					<a href="/" class = "btn btn-outline-danger">취소</a>
				</form>	
			</div>
	</div>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>