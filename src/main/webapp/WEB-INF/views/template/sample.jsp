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

		
		
		<!-- 코드 작성 라인 -->
		<c:import url="/WEB-INF/views/template/footer.jsp"></c:import>
		</div>
	</div>
	<c:import url="/WEB-INF/views/template/footerScript.jsp"></c:import>
</body>
</html>