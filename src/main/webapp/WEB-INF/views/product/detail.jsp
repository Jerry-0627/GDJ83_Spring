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
					<h1 class="mt-4">Product Detail</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">상세 정보</li>
					</ol>


					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> DataTable
						</div>
						<div class="card-body">

							<div class="container">

								<table class="table table-hover">
									<thead>
										<tr>
											<th>product_num</th>
											<th>product_name</th>
											<th>product_rate</th>
											<th>product_ex</th>
										</tr>
									</thead>
									<tbody>
										<td>${detail.product_num }</td>
										<td>${detail.product_name }</td>
										<td>${detail.product_rate }</td>
										<td>${detail.product_ex }</td>
									</tbody>
								</table>

								<div class="mb-4">
								<a href="../account/add?product_num=${detail.product_num}"
								class = "btn btn-outline-primary">상품 가입</a>
								<a href="./update?product_num=${detail.product_num}"
								class = "btn btn-outline-warning">상품 수정</a>
								<a href="./delete?product_num=${detail.product_num}"
								class = "btn btn-outline-danger">상품 삭제</a>
								
								<a type ="button" id="addWish" data-product-id="${detail.product_num}" href="#" class = "btn btn-warning">
								<!-- 버튼으로 만들어도 상관없음 -->
									관심목록에 추가</a>
								</div>
								<div>
									<c:forEach items="${detail.product_file}" var="f">
										<a class="btn btn-info" href="/resources/upload/products/${f.file_name}">${f.ori_name}</a>
									</c:forEach>
								</div>
								<div id="wishResult">

								</div>
								
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
	<script src="/resources/js/product/wish.js"></script>
</body>
</html>