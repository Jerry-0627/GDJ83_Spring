<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Product
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/product/list">Product List</a>
                                    <a class="nav-link" href="/product/wishList">Wish List</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Board
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <div id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                            <a class="nav-link" href="/notice/list">Notice</a>
                                    </div>
                                    <div id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                            <a class="nav-link" href="/qna/list">QnA</a>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Addons</div>
                            <c:choose>
                            <c:when test="${not empty member }">
                             <a class="nav-link" href="/member/myPage">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                My Page
                            </a>
                             <a class="nav-link" href="/member/logoutMember">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Log Out
                            </a>
                            </c:when>
                            <c:when test="${empty member }">
                            <a class="nav-link" href="/member/loginMember">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Log In
                            </a>
                            <a class="nav-link" href="/member/join123">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                123으로 로그인
                            </a>
                            <a class="nav-link" href="/member/joinMember">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                Register
                            </a>
                            </c:when>
                            </c:choose>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>