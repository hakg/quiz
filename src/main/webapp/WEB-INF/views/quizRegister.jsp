<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <!-- event JavaScript -->
    <script src="/resources/static/js/account.js"></script>
</head>

<div class="text-center">
    <h1 class="h4 text-gray-900 mb-4">문제 정보 관리</h1>
</div>
<div class="container-fluid">

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Quiz List</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Category</th>
                            <th>Quiz Info</th>
                            <th>Insert ID</th>
                            <th>Insert Date</th>
                            <th>Modify ID</th>
                            <th>Modify Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${quizList}" var="question">
                            <tr>
                                <td>${question.no}</td>
                                <td>${question.category}</td>
                                <td>${question.quizInfo}</td>
                                <td>${question.insertId}</td>
                                <td>${question.insertDate}</td>
                                <td>${question.modifyId}</td>
                                <td>${question.modifyDate}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
