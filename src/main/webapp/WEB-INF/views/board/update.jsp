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
			<h1>${board} 세부사항 수정</h1>
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
					<label for="board_title" class="form-label">제목</label> 
					<input type="text" class="form-control" id="board_title" name="board_title" value="${getDetail.board_title}" >
				</div>
					
				<div class="mb-3">
					<label for="board_contents" class="form-label">내용</label>
					<textarea rows="" cols="" class="form-control" id="board_contents" name = "board_contents">${getDetail.board_contents}
					</textarea> 
				</div>
					
				<div>
					<button type = "submit" class = "btn btn-primary">수정 완료</button>
					<a type = "btn" class = "btn btn-outline-danger" href="./detail?board_num=${getDetail.board_num}">취소하기</a>	
				</div>	
			</div>
		</form>

			<!-- 코드 작성 라인 -->
		<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
		</div>		
	</div>
	<c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import>
</body>
</html>