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
					<h1 class="mt-4">My Page</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">내 정보</li>
					</ol>
					<c:if test="${not empty member.memberFileDTO}">
						<div>
							<img alt="" src="/resources/upload/members/${member.memberFileDTO.file_name}">
						</div>	
					</c:if>
					<c:if test="${empty member.memberFileDTO}">
						<div>
							<img alt="" src="/resources/upload/members/dog.jpg">
						</div>	
					</c:if>


					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> DataTable
						</div>
						<div class="card-body">

							<div class="container">

								<div class="mb-3">
									<label for="user_name" class="form-label">회원 이름</label> <input
										type="text" class="form-control" id="user_name"
										name="user_name" value="${member.user_name}" disabled>
								</div>
								<div class="mb-3">
									<label for="user_phone_num" class="user_phone_num">회원
										전화번호</label> <input type="text" class="form-control"
										id="user_phone_num" name="user_phone_num"
										value="${member.user_phone_num}" disabled>
								</div>
								<div class="mb-3">
									<label for="user_email" class="form-label">회원 이메일</label> <input
										type="email" class="form-control" id="user_email"
										name="user_email" value="${member.user_email}" disabled>
								</div>
								<div class="mb-3">
									<label for="user_address" class="form-label">회원 주소</label> <input
										type="text" class="form-control" id="user_address"
										name="user_address" value="${member.user_address}" disabled>
								</div>
								<div class="container">
									<h1>계좌정보</h1>
									<c:forEach items="${member.dtos}" var="ac">
										<label class="form-label"> <a
											href="../account/detail?account_num=${ac.account_num}"
											class="btn btn-light" role="button">${ac.account_num} 계좌
												정보 보기 </a>
										</label>
										<input class="form-control" value=" 잔액 : ${ac.balance}"
											disabled>
									</c:forEach>
								</div>
								<div class="container">
									<a type="button" href="./update" class="btn btn-primary">회원
										정보 수정</a> <a type="button" href="/" class="btn btn-danger">홈으로
										돌아가기</a>
									<form action="./delete">
										<button class="btn btn-warning">회원 탈퇴</button>
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
</body>
</html>