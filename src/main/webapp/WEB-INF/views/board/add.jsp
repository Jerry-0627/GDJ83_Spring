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
	<h1>${board} 추가</h1>
		<form  method="post">
			<input type = "hidden" value = "${getDetail.board_num}" name="">
			<div class="mb-3">
				<label for="board_writer" class="form-label">작성자</label>
				<input type="text" class="form-control" id="board_writer" name = "board_writer" value="${member.user_id}" disabled>
			</div>

			<div class="mb-3">
			 	<label for="board_title" class="form-label">제목</label>
			  	<input type="text" class="form-control" id="board_title" name = "board_title">
			</div>
			<div class="mb-3">
				<label for="board_contents" class="form-label">내용</label>
				<textarea rows="" cols="" class="form-control" id="board_contents" name = "board_contents"></textarea>
			</div>
				
				
			<button type = "submit" class = "btn btn-primary">등록</button>
			<a href="./list" class = "btn btn-outline-danger">취소</a>
				
		</form>	
	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>