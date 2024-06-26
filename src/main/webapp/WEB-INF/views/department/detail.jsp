<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 상세정보</h1>
	
	<h3>${dto.department_id }</h3>
	<h3>${dto.department_name}</h3>
	<h3>${dto.manager_id}</h3>
	<h3>${dto.location_id}</h3>
	
	<a href="./delete?department_id=${dto.department_id}">삭제</a>
	
	<a href="./update?department_id=${dto.department_id}">수정</a>
	
	
</body>
</html>