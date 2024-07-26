<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>댓글 번호</th>
				<th>상품 번호</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${commentList}" var="list" varStatus="i">
				<tr>
					<td>${list.board_num}</td>
					<td>${list.product_num }</td>
					<td>${list.board_writer }</td>
					<td>${list.create_date }</td>
					<td id="con${i.count}">${list.board_contents}</td>
					<td><c:if test="${list.board_writer eq member.user_id}"><button class="btn btn-danger commentListBtn" 
						data-commentListBtn = "${list.board_num}">X</button></c:if></td>
					<td><c:if test="${list.board_writer eq member.user_id}"><button class="btn btn-outline-primary ups" 
						data-update-con="con${i.count}"
						data-commentListBtn = "${list.board_num}"
						data-bs-toggle="modal" data-bs-target="#commentModal">수정</button></c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<nav aria-label="Page navigation example">
			<ul class="pagination">

				<li class="page-item ${pageDTO.pre?'':'disabled' }">
					<a
						data-page-num="${pageDTO.startNum-1}"
						class="page-link pageList"
						href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a>
				</li>

				<c:forEach begin="${pageDTO.startNum}" end="${pageDTO.lastNum}"
					step="1" var="i">
					<li class="page-item">
						<a 
							data-page-num="${i}"
							class="page-link pageList"
							href="#">${i}
						</a>
					</li>
				</c:forEach>

				<li class="page-item ${pageDTO.next?'':'disabled' }">
					<a
					data-page-num="${pageDTO.lastNum+1}"
					class="page-link pageList"
					href="#"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</ul>
		</nav>
	</div>
</body>
</html>