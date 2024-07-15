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
		<div class="row">
			<h1>세부사항 수정</h1>
		</div>
		<form action="./update" method="post">
			
			<div class="row">					
				<div class="mb-3">
					<label for="board_num" class="form-label">번호</label> 
					<input type="text" class="form-control" id="board_num" value="${getDetail.board_num}" disabled>
					<input type="hidden" name="board_num" value="${getDetail.board_num}">
					
				</div>
					
				<div class="mb-3">
					<label for="board_writer" class="form-label">작성자</label> 
					<input type="text" class="form-control" id="board_writer" value="${getDetail.board_writer}" disabled>
					<input type="hidden" name="board_writer" value="${getDetail.board_writer}">
					
				</div>
					
				<div class="mb-3">
					<label for="create_date" class="form-label">작성일</label> 
					<input type="text" class="form-control" id="create_date" value="${getDetail.create_date}" disabled>
					<input type="hidden" name="create_date" value="${getDetail.create_date}">
				</div>
					
				<div class="mb-3">
					<label for="update_date" class="form-label">수정일</label> 
					<input type="text" class="form-control" id="update_date" value="${getDetail.update_date}" disabled>
				</div>
					
				<div class="mb-3">
					<label for="board_category" class="form-label">카테고리</label> 
					<input type="text" class="form-control" id="board_category" name="board_category" value="${getDetail.board_category}" >
				</div>
					
				<div class="mb-3">	
					<label for="board_title" class="form-label">제목</label> 
					<input type="text" class="form-control" id="board_title" name="board_title" value="${getDetail.board_title}" >
				</div>
					
				<div class="mb-3">
					<label for="board_contents" class="form-label">내용</label> 
					<input type="text" class="form-control" id="board_contents" name="board_contents" value="${getDetail.board_contents}" >
				</div>
					
				<div>
					<button type = "submit" class = "btn btn-primary">수정 완료</button>
					<a type = "btn" class = "btn btn-outline-danger" href="./detail?board_num=${getDetail.board_num}">취소하기</a>	
				</div>	
			</div>
		</form>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>	
</body>
</html>