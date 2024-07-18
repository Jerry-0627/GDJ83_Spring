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
					<h1 class="mt-4">Product List</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">상품 목록</li>
					</ol>


					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> DataTable
						</div>
						<div class="card-body">

							<div class="container">
								<form action="./list" method="get"
									class="row row-cols-lg-auto g-3 align-items-center">

									<div class="col-12">
										<label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
										<select name="kind" class="form-select"
											id="inlineFormSelectPref">
											<option value="k1">상품명</option>
											<option value="k2">상품내용</option>

										</select>
									</div>
									<div class="col-12">
										<label class="visually-hidden"
											for="inlineFormInputGroupUsername">Username</label>
										<div class="input-group">
											<input type="text" name="search" class="form-control"
												id="inlineFormInputGroupUsername" placeholder="Username">
										</div>
									</div>

									<div class="col-12">
										<button type="submit" class="btn">Submit</button>
									</div>
								</form>
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
										<c:forEach items="${list}" var="dto">
											<tr>
												<th>${dto.product_num}</th>
												<th><a href="./detail?product_num=${dto.product_num}">${dto.product_name}</a></th>
												<th>${dto.product_rate}</th>
												<th>${dto.product_ex}</th>
											</tr>
										</c:forEach>
									</tbody>
								</table>

								<div class="mb-4">
									<a href="./add" class="btn btn-outline-primary">상품 등록</a>
								</div>
								
								<div>
									<nav aria-label="Page navigation example">
										<ul class="pagination">

											<li class="page-item ${pageDTO.pre?'':'disabled' }"><a
												class="page-link"
												href="./list?page=${pageDTO.startNum-1}&kind=${pageDTO.kind}&search=${pageDTO.search}"
												aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											</a></li>

											<c:forEach begin="${pageDTO.startNum}"
												end="${pageDTO.lastNum}" step="1" var="i">
												<li class="page-item"><a class="page-link"
													href="./list?page=${i}&kind=${pageDTO.kind}&search=${pageDTO.search}">${i}</a></li>
											</c:forEach>

											<li class="page-item ${pageDTO.next?'':'disabled' }"><a
												class="page-link"
												href="./list?page=${pageDTO.lastNum+1}&kind=${pageDTO.kind}&search=${pageDTO.search}"
												aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											</a></li>
										</ul>
									</nav>
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
</body>
</html>