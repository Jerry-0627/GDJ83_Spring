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
	<div class = "container">
		<h1>공지사항</h1>
		
		<form class="row row-cols-lg-auto g-3 align-items-center">
			<div class="col-12">
		    <select name="kind" class="form-select" id="inlineFormSelectPref">
		      	<option value="k1">제목</option>
		      	<option value="k2">내용</option>
		    	<option value="k3">작성자</option>
		    </select>
		  	</div>
		  	<div class="col-12">
		  		<div class="input-group">
		  			 <label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
		     		 <input name="search" type="text" class="form-control" id="inlineFormInputGroupUsername" placeholder="${map.search }">
		   	 	</div>
		  	</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">검색</button>
			</div>	
			<div>
				<a href="/notice/add" class="btn btn-success">글쓰기</a>
			</div>
		</form>
		
	
	
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">번호</th>
		      <th scope="col">제목</th>
		      <th scope="col">작성자</th>
		      <th scope="col">작성일</th>
		      <th scope="col">수정일</th>
		      <th scope="col">조회수</th>
		      <th scope="col">카테고리</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items = "${map.list}" var = "dto"> 
				<tr>
					<td>${dto.board_num}</td>
					<td><a href="./detail?board_num=${dto.board_num}">${dto.board_title}</a></td>
					<td>${dto.board_writer}</td>
					<td>${dto.create_date}</td>
					<td>${dto.update_date}</td>
					<td>${dto.board_hit}</td>
					<td>${dto.board_category}</td>
				</tr>
			</c:forEach>
		  </tbody>
		</table>
		
		<ul class="pagination">
	   		<li class="page-item ${map.pre?'':'disabled' }">
     			<a class="page-link" href="./list?page=${map.startNum-1}&kind=${map.kind}&search=${map.search}" aria-label="Previous">
	        		<span aria-hidden="true">&laquo;</span>
	      		</a>
	    	</li>
		    <c:forEach begin="${map.startNum}" end ="${map.lastNum}" step="1" var="i"> 
			    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${map.kind}&search=${map.search}">${i}</a></li>
			</c:forEach>
		    <li class="page-item ${map.next?'':'disabled' }">
		      <a class="page-link" href="./list?page=${map.lastNum+1}&kind=${map.kind}&search=${map.search}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
	  	</ul>

	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>