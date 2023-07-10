<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<style>
    .custom-button {
        display: inline-block;
        color: #fff;
        background-color: #4e73df;
        border: none;
        padding: 8px;
        border-radius: 6px;
        font-size: 15px;
        font-weight: bold;
    }
</style>
</head>

<div class="card mb-4 py-3 border-left-primary" style="margin-top: 100px;">
    <div id="questionTitle" class="card-body" style="text-align: center;">
        오버라이딩(Overriding)과 오버로딩(Overloading)에 대해 설명해주세요. !
    </div>
</div>

<textarea type="text" class="form-control form-control-user" id="exampleInputAnswer"  placeholder="정답을 적어주세요." style="margin-top: 30px;"></textarea>

<div style=" text-align: center; margin-top: 30px;">
	<button class="custom-button" style="display: inline-block; ">정답 제출</button>
</div>

<div class="progress mb-4" style="margin-top: 150px;">
    <div class="progress-bar" role="progressbar" style="width: 50%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
</div>
<script src="/resources/static/js/question.js"></script>





