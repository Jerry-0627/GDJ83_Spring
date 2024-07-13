<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

	<h1>detail</h1>
	<h1>공지 번호 : ${doAdd.board_num}</h1>
	<h1>공지 작성자 : ${doAdd.board_writer}</h1>
	<h1>공지 제목 : ${doAdd.board_title}</h1>
	<h1>공지 작성일 :${doAdd.create_date}</h1>
	<h1>공지 수정일 : ${doAdd.update_date}</h1>
	<h1>공지 내용 : ${doAdd.board_contents}</h1>
	<h1>공지 카테고리 : ${doAdd.board_category}</h1>
	
	
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>