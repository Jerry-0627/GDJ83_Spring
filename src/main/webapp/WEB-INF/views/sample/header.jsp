<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">HOME</a>
    <a class="navbar-brand" href="/product/list">금융상품</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">기타1</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">기타2</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
<%--
        <c:if test="${not empty member }">
	        <li class="nav-item">
	        	  <a class="nav-link" href="/member/myPage">마이페이지</a>
	        </li>
	        <li class="nav-item">
	        	  <a class="nav-link" href="/member/logoutMember">로그아웃</a>
	        </li>
        </c:if>
        <c:if test="${empty member }">
	        <li class="nav-item">
	          	<a class="nav-link" href="/member/joinMember">회원가입</a>
	        </li>
	        <li class="nav-item">
	          	<a class="nav-link" href="/member/loginMember">로그인</a>
	        </li>
        </c:if>    
--%>
		<c:choose>
			<c:when test="${not empty member }">
				 <li class="nav-item">
	        	 <a class="nav-link" href="/member/myPage">마이페이지</a>
	       		 </li>
	       		 <li class="nav-item">
	        	 <a class="nav-link" href="/member/logoutMember">로그아웃</a>
	        </li>
			</c:when>
			<c:when test="${empty member }">
				 <li class="nav-item">
	    	 		 <a class="nav-link" href="/member/joinMember">회원가입</a>
	             </li>
	             <li class="nav-item">
	            	<a class="nav-link" href="/member/loginMember">로그인</a>
	    	     </li>
			</c:when>
			<%--
			<c:otherwise>
			</c:otherwise>
			--%>
		</c:choose>
        
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
