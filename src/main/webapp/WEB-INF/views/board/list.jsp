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
		<h1>${board} 리스트</h1>
		
		<form class="row row-cols-lg-auto g-3 align-items-center">
			<div class="col-12">
		    <select name="kind" class="form-select" id="inlineFormSelectPref">
		      	<option value="title">제목</option>
		      	<option value="contents">내용</option>
		    	<option value="writer">작성자</option>
		    </select>
		  	</div>
		  	<div class="col-12">
		  		<div class="input-group">
		  			 <label class="visually-hidden" for="inlineFormInputGroupUsername">Username</label>
		     		 <input name="search" type="text" class="form-control" id="inlineFormInputGroupUsername" placeholder="${pageDTO.search }">
		   	 	</div>
		  	</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">검색</button>
			</div>	
			<div>
				<a href="./add" class="btn btn-success">글쓰기</a>
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
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items = "${list}" var = "dto"> 
				<tr>
					<td> 
						<c:if test="${dto.del eq 0}">
							${dto.board_num}
						</c:if>
					</td>
					
					
					<td>
						<c:choose>
							<c:when test="${dto.del eq 0}">
								<a href="./detail?board_num=${dto.board_num}">
									<c:catch>
										<c:forEach begin="1" end="${dto.depth}">━━></c:forEach>
									</c:catch>	
									${dto.board_title}
								</a>
							</c:when>
							<c:otherwise>
									<c:catch>
										<c:forEach begin="1" end="${dto.depth}">━━></c:forEach>
									</c:catch>	
									삭제된 글입니다.
							</c:otherwise>
						</c:choose>
					 </td>
					 
					<td>
						<c:if test="${dto.del eq 0}">
							${dto.board_writer}
						</c:if>
					</td>
					<td>
						<c:if test="${dto.del eq 0}">
							${dto.create_date}
						</c:if>	
					</td>
					<td>
						<c:if test="${dto.del eq 0}">	
							${dto.update_date}
						</c:if>	
					</td>
					<td>
						<c:if test="${dto.del eq 0}">	
							${dto.board_hit}
						</c:if>	
					</td>
				</tr>
			</c:forEach>
		  </tbody>
		</table>
		
		<ul class="pagination">
	   		<li class="page-item ${pageDTO.pre?'':'disabled' }">
     			<a class="page-link" href="./list?page=${pageDTO.startNum-1}&kind=${pageDTO.kind}&search=${pageDTO.search}" aria-label="Previous">
	        		<span aria-hidden="true">&laquo;</span>
	      		</a>
	    	</li>
		    <c:forEach begin="${pageDTO.startNum}" end ="${pageDTO.lastNum}" step="1" var="i"> 
			    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pageDTO.kind}&search=${pageDTO.search}">${i}</a></li>
			</c:forEach>
		    <li class="page-item ${pageDTO.next?'':'disabled' }">
		      <a class="page-link" href="./list?page=${pageDTO.lastNum+1}&kind=${pageDTO.kind}&search=${pageDTO.search}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
	  	</ul>

	</div>
	<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>