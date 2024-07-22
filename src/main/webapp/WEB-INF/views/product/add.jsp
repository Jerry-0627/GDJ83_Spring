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
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">Product Add</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">상품 추가</li>
					</ol>


					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> DataTable
						</div>	
						<div class="card-body">

							<div class="container">

								<form action="./add" method="post" enctype="multipart/form-data">
									<div class="mb-3">
										<label for="product_name" class="form-label">상품 이름</label> <input
											type="text" class="form-control" id="product_name"
											name="product_name">
									</div>
									<div class="mb-3">
										<label for="product_rate" class="form-label">상품 이자율</label> <input
											type="text" class="form-control" id="product_rate"
											name="product_rate">
									</div>
									<div class="mb-3">
										<label for="product_ex" class="form-label">상품 설명</label> <input
											type="text" class="form-control" id="product_ex"
											name="product_ex">
									</div>

									<div class="mb-3">
										<button type="button" id="add" class="btn btn-primary">파일 추가</button>
									</div>
									<div id="result">

									</div>


									<button type="submit" class="btn btn-primary">등록</button>
									<a href="./list" class="btn btn-outline-danger">취소</a>

								</form>



							</div>
						</div>
					</div>
				</div>
			</main>


		<!-- 코드 작성 라인 -->
		<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
		</div>		
	</div>
	<c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import>
	<script src="/resources/js/commons/files.js"></script>
	<script>
		setMax(5);
	</script>
</body>
</html>