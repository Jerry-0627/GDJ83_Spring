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
					<h1 class="mt-4">User Update</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">회원 정보 수정</li>
					</ol>


					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> DataTable
						</div>
						<div class="card-body">

							<div class="container">

								<form action="./update" method="post">

									<div class="mb-3">
										<label for="user_name" class="form-label">회원 이름</label> <input
											type="text" class="form-control" id="user_name"
											name="user_name" value="${member.user_name}">
									</div>
									<div class="mb-3">
										<label for="user_phone_num" class="user_phone_num">회원
											전화번호</label> <input type="text" class="form-control"
											id="user_phone_num" name="user_phone_num"
											value="${member.user_phone_num}">
									</div>
									<div class="mb-3">
										<label for="user_email" class="form-label">회원 이메일</label> <input
											type="email" class="form-control" id="user_email"
											name="user_email" value="${member.user_email}">
									</div>
									<div class="mb-3">
										<label for="user_address" class="form-label">회원 주소</label> <input
											type="text" class="form-control" id="user_address"
											name="user_address" value="${member.user_address}">
									</div>
									<button class="btn btn-primary">등록</button>
									<a href="./myPage" class="btn btn-outline-danger">취소</a>

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
</body>
</html>