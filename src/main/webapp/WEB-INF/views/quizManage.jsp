<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <style>
        .custom-heading {
            text-align: left;
        }
    </style>
</head>

<div class="text-center">
    <h1 class="h4 text-gray-900 mb-4">문제 정보 관리</h1>
</div>
<div class="container-fluid">

    <!-- Registration Modal -->
    <div class="modal fade" id="registrationModal" tabindex="-1" role="dialog" aria-labelledby="registrationModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="registrationModalLabel">새로운 퀴즈 등록</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="registrationForm">
                        <div class="form-group">
                            <label for="category">Category:</label>
                            <input type="text" class="form-control" id="category" name="category" required>
                        </div>
                        <div class="form-group">
                            <label for="quizInfo">Quiz Info:</label>
                            <textarea class="form-control" id="quizInfo" name="quizInfo" rows="4" required></textarea>
                        </div>
                        <!-- Add other fields as needed -->
                        <button type="button" class="btn btn-primary" onclick="submitRegistrationForm()">등록</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Quiz List Table -->
    <div class="card shadow mb-4">
        <div class="card-header py-3 d-flex justify-content-end">
            <button class="btn btn-primary text-right" onclick="performAction('select')">조회</button>
            <button class="btn btn-primary text-right" data-toggle="modal" data-target="#registrationModal">등록</button>
            <button class="btn btn-primary text-right" onclick="performAction('update')">수정</button>
            <button class="btn btn-primary text-right" onclick="performAction('delete')">삭제</button>
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
                                <td><fmt:formatDate value="${question.insertDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                <td>${question.modifyId}</td>
                                <td><fmt:formatDate value="${question.modifyDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script>
    function performAction(action) {
        $.ajax({
            type: 'GET',
            url: '/quizManage', // URL to handle the form submission
            success: function (response) {
                $('#mainContent').html(response);
                $('#registrationModal').modal('hide');
            },
            error: function (error) {
                console.error('Error submitting the form: ' + error);
            }
        });
    }

    function submitRegistrationForm() {
            var formData = {
                'category': $('#category').val(),
                'quizInfo': $('#quizInfo').val()
            };

            $.ajax({
                type: 'POST',
                url: '/quizInsert', // URL to handle the form submission
                data: JSON.stringify(formData),
                success: function (response) {
                    $('#registrationModal').modal('hide');
                },
                error: function (error) {
                }
            });
        }
</script>
