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
			<h1>공지 세부사항</h1>
		</div>
		<div class="row">				
			<div class="mb-3">
				<label for="" class="form-label">공지 번호</label> 
				<input type="text" class="form-control" id="" name="" value="${getDetail.board_num}" disabled>
			</div>
				
			<div class="mb-3">
				<label for="" class="form-label">공지 작성자</label> 
				<input type="text" class="form-control" id="" name="" value="${getDetail.board_writer}" disabled>
			</div>
				
			<div class="mb-3">
				<label for="" class="form-label">공지 작성일</label> 
				<input type="text" class="form-control" id="" name="" value="${getDetail.create_date}" disabled>
			</div>
				
			<div class="mb-3">
				<label for="" class="form-label">공지 수정일</label> 
				<input type="text" class="form-control" id="" name="" value="${getDetail.update_date}" disabled>
			</div>
				
			<div class="mb-3">
				<label for="" class="form-label">공지 카테고리</label> 
				<input type="text" class="form-control" id="" name="" value="${getDetail.board_category}" disabled>
			</div>
				
			<div class="mb-3">
				<label for="" class="form-label">공지 제목</label> 
				<input type="text" class="form-control" id="" name="" value="${getDetail.board_title}" disabled>
			</div>
				
			<div class="mb-3">
				<label for="" class="form-label">공지 내용</label> 
				<input type="text" class="form-control" id="" name="" value="${getDetail.board_contents}" disabled>
			</div>
				
			<div>
				<a type = "btn" class = "btn btn-primary" href="./update?board_num=${getDetail.board_num}">수정하기</a>
				<a type = "btn" class = "btn btn-danger" href="/notice/delete?board_num=${getDetail.board_num}">삭제하기</a>
				<a type = "btn" class = "btn btn-outline-danger" href="/notice/list">뒤로가기</a>
			</div>	
				
		</div>
<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>	
</body>
</html>