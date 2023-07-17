<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>

</head>


<div class="text-center">
    <h1 class="h4 text-gray-900 mb-4">회원정보 수정</h1>
</div>
<form class="UserDTO" id="UserDTO" action="회원정보 수정 처리 페이지의 URL" method="POST">
    <div class="form-group">
        <input type="text" class="form-control form-control-user" id="userName" required="true" placeholder="이름 입력(2자~4자)" value=<c:out value="${UserDTO.userName}" /> disabled>
    </div>
    <div class="form-group">
        <input type="text" class="form-control form-control-user" id="userId" required="true" value=<c:out value="${UserDTO.userId}" /> disabled>
    </div>
    <div class="form-group row">
        <div class="col-sm-6 mb-3 mb-sm-0">
            <input type="password" class="form-control form-control-user" id="password" required="true" placeholder="변경할 패스워드 입력(최소8자 숫자,문자,특문 포함)">
        </div>
        <div class="col-sm-6">
            <input type="password" class="form-control form-control-user" id="repeatPassword" required="true"  placeholder="변경할 패스워드 확인(최소8자 숫자,문자,특문 포함)">
        </div>
    </div>
    <div id="signUpBtn" class="btn btn-primary btn-user btn-block">회원정보 수정 완료</div>
</form>
<hr>
<div class="text-center">
    <a class="small" href="/logout">로그아웃</a>
</div>


<!-- event JavaScript -->
<script src="/resources/static/js/account.js"></script>

