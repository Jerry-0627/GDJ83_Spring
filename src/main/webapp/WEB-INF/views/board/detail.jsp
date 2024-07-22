<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/template/header.jsp"></c:import>
<c:import url="/WEB-INF/views/template/headerScript.jsp"></c:import>
</head>
<body class="sb-nav-fixed">
	<c:import url="/WEB-INF/views/template/navbar.jsp"></c:import>
	<div id="layoutSidenav">
		<c:import url="/WEB-INF/views/template/sidenav.jsp"></c:import>
		<div id="layoutSidenav_content">
		<!-- 코드 작성 라인-->
	<div class="container">
		<div class="row">
			<h1>${board} 세부사항</h1>
		</div>
		<div class="row">				
			<div class="mb-3">
				<label for="" class="form-label">번호</label> 
				<input type="text" class="form-control" id="" name="" value="${getDetail.board_num}" disabled>
			</div>
				
			<div class="mb-3">
				<label for="" class="form-label">작성자</label> 
				<input type="text" class="form-control" id="" name="" value="${getDetail.board_writer}" disabled>
			</div>
				
			<div class="mb-3">
				<label for="" class="form-label">작성일</label> 
				<input type="text" class="form-control" id="" name="" value="${getDetail.create_date}" disabled>
			</div>
				
			<div class="mb-3">
				<label for="" class="form-label">수정일</label> 
				<input type="text" class="form-control" id="" name="" value="${getDetail.update_date}" disabled>
			</div>
				
			<div class="mb-3">
				<label for="" class="form-label">제목</label> 
				<input type="text" class="form-control" id="" name="" value="${getDetail.board_title}" disabled>
			</div>
				
			<div class="mb-3">
				<label for="" class="form-label">내용</label> 
				<textarea rows="" cols="" class="form-control" id="board_contents" name = "board_contents" disabled>${getDetail.board_contents}
				</textarea>
			</div>
			<div>
				<c:forEach items="${getDetail.board_file}" var="f">
					<a class="btn btn-info" href="/resources/upload/products/${f.file_name}">${f.ori_name}</a>
				</c:forEach>
			</div>
				
			<div>
				<c:if test="${board ne 'Notice'}">
					<a type = "btn" class = "btn btn-info" href="./reply?board_num=${getDetail.board_num}">답글 달기</a>				
				</c:if>
				<c:if test="${getDetail.board_writer eq member.user_id}">
					<a type = "btn" class = "btn btn-primary" href="./update?board_num=${getDetail.board_num}">수정하기</a>
					<a type = "btn" class = "btn btn-danger" href="./delete?board_num=${getDetail.board_num}">삭제하기</a>
				</c:if>
				<a type = "btn" class = "btn btn-outline-danger" href="./list">뒤로가기</a>
			</div>	
				
		</div>

			<!-- 코드 작성 라인 -->
		<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
		</div>		
	</div>
	<c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import>
</body>
</html>