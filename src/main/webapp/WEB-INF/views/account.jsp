<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>

</head>


<div class="text-center">
    <h1 class="h4 text-gray-900 mb-4">회원정보 수정</h1>
</div>
<div class="row justify-content-center">
    <div class="col-sm-6">
        <form class="UserDTO" id="UserDTO">
            <div class="form-group row">
                <label for="userId" class="col-sm-4 col-form-label text-right">사용자 ID</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control form-control-user" id="userId" required="true" value=<c:out value="${UserDTO.userId}" /> disabled>
                </div>
            </div>
            <div class="form-group row">
                <label for="userName" class="col-sm-4 col-form-label text-right">사용자 이름</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control form-control-user" id="userName" required="true" value=<c:out value="${UserDTO.userName}" />>
                </div>
            </div>
            <div class="form-group row">
                <label for="password" class="col-sm-4 col-form-label text-right">변경할 패스워드</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control form-control-user" id="password" required="true" placeholder="변경할 패스워드 입력(최소8자 숫자,문자,특문 포함)">
                </div>
            </div>
            <div class="form-group row">
                <label for="repeatPassword" class="col-sm-4 col-form-label text-right">패스워드 확인</label>
                <div class="col-sm-8">
                    <input type="password" class="form-control form-control-user" id="repeatPassword" required="true" placeholder="변경할 패스워드 확인(최소8자 숫자,문자,특문 포함)">
                </div>
            </div>
            <div id="accountUpdateBtn" class="btn btn-primary btn-user btn-block">회원정보 수정 완료</div>
        </form>
    </div>
</div>

<!-- event JavaScript -->
<script src="/resources/static/js/account.js"></script>

