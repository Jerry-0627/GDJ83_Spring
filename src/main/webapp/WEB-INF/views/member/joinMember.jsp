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
					<h1 class="mt-4">Register</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">회원 등록</li>
					</ol>


					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> DataTable
						</div>
						<div class="card-body">

							<div class="container">

								<div class="row">
									<form action="./joinMember" method="post" id="frm" enctype="multipart/form-data">
									<!-- 7.19 뒤에  enctype="multipart/form-data" 는 파일을 여러개로 짤라서 보내겠다라는 뜻-->
									<!-- 잘라진 파일을 다운 받으려면 잘라진 파일을 합쳐주는 라이브러리를 다운 해야함. -->
										<div class="mb-3">
											<label for="user_id" class="form-label">회원 아이디</label> <input
												type="text" class="form-control" id="user_id" name="user_id">
										</div>
										<div class="mb-3">
											<label for="user_pw" class="form-label">회원 비밀번호</label> <input
												type="password" class="form-control" id="user_pw">
												<div id="password-error" class="text-danger"></div>
										</div>
										<div class="mb-3">
											<label for="user_pw" class="form-label">회원 비밀번호</label> <input
												type="password" class="form-control" id="user_pw_check"
												name="user_pw">
												<div id="password-eqError" class="text-danger"></div>
												<div id="password-eqError2" class="text-primary"></div>
										</div>
										<div class="mb-3">
											<label for="user_name" class="form-label">회원 이름</label> <input
												type="text" class="form-control" id="user_name"
												name="user_name">
										</div>
										<div class="mb-3">
											<label for="user_phone_num" class="user_phone_num">회원
												전화번호</label> <input type="text" class="form-control"
												id="user_phone_num" name="user_phone_num"
												placeholder="000-0000-0000">
										</div>
										<div class="mb-3">
											<label for="user_email" class="form-label">회원 이메일</label> <input
												type="email" class="form-control" id="user_email"
												name="user_email" placeholder="ABC@DEFG.com">
										</div>
										<div class="mb-3">
											<label for="user_address" class="form-label">회원 주소</label> <input
												type="text" class="form-control" id="user_address"
												name="user_address" placeholder="XX시-XX구-XX동">
										</div>
										<button type="button" id="add" class="btn btn-primary">사진 파일 추가</button>
										
										<div class="mb-3" id="result">
											<!-- 여기다 만들 수 있도록 추가하기 -->
										</div>
										
										<button type="button" id="btn" class="btn btn-primary">등록</button>
										<a href="/" class="btn btn-outline-danger">취소</a>

									</form>
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
	<script type="text/javascript" src="/resources/js/member/memberJoinCheck.js"></script>
	<script type="text/javascript" src="/resources/js/commons/files.js"></script>
</body>
</html>