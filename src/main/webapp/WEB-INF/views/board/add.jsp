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
<style>
	.ck.ck-editor{
	   max-width: 1000px;
  }
  .ck-editor__editable {
     min-height: 400px;
     max-height: 600px;
  }
  .ck-content { 
	  font-size: 12px; 
	 }
</style>
</head>
<body class="sb-nav-fixed">
	<c:import url="/WEB-INF/views/template/navbar.jsp"></c:import>
	<div id="layoutSidenav">
		<c:import url="/WEB-INF/views/template/sidenav.jsp"></c:import>
		<div id="layoutSidenav_content">
		<!-- 코드 작성 라인-->
	<div class="container">
	<h1>${board} 추가</h1>
		<form  method="post" enctype="multipart/form-data">
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
				<textarea rows="" cols="" class="form-control" id="editor" name = "board_contents"></textarea>
			</div>
			
			<button type="button" id="add" class="btn btn-primary">사진 파일 추가</button>
										
			<div class="mb-3" id="result">
			<!-- 여기다 만들 수 있도록 추가하기 -->
			</div>
				
			<button type = "submit" class = "btn btn-primary">등록</button>
			<a href="./list" class = "btn btn-outline-danger">취소</a>
				
		</form>	
	</div>

			<!-- 코드 작성 라인 -->
		<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
		</div>		
	</div>
	<c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import>
	<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script>
	<script type="text/javascript" src="/resources/js/commons/files.js"></script>
	<script>
		setMax(5);
		ClassicEditor.create( 
				document.getElementById( 'editor' ), {
					extraPlugins: [MyCustomUploadAdapterPlugin]
		       },
			   
		     )
			 .then(editor=>{
				window.editor=editor
			 })
			 
			 .catch(error=>{
					console.log('error')
			 });	
			
	</script>
	<script src="/resources/js/commons/ckeditor" type="text/javascript"></script>
</body>
</html>