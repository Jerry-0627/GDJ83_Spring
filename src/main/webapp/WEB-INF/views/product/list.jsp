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

	<table class = "table table-striped table-primary">
		<thead>
			<h1>금융 상품 목록</h1>
			<tr>
				<th>상품 번호</th>
				<th>상품 이름</th>
				<th>상품 이자율</th>
				<th>상품 설명</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items = "${map.list}" var = "dto"> 
				<tr>
					<td>${dto.product_num}</td>
					<td><a href="./detail?product_num=${dto.product_num}">${dto.product_name}</a></td>
					<td>${dto.product_rate}</td>
					<td>${dto.product_ex}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
			<a href="./add" class = "btn btn-outline-primary">상품 등록</a>	
			<a href="/" class = "btn btn-outline-danger">뒤로가기</a>
					
	</div>
	<nav aria-label="Page navigation example">
  <ul class="pagination">
  
    <li class="page-item ${map.pre?'':'disabled' }">
      <a class="page-link" href="./list?page=${map.startNum-1}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    
    <c:forEach begin="${map.startNum}" end ="${map.lastNum}" step="1" var="i"> 
	    <li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
	</c:forEach>

    <li class="page-item ${map.next?'':'disabled' }">
      <a class="page-link" href="./list?page=${map.lastNum+1}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>