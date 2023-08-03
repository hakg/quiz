<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <button class="btn btn-primary text-right" data-toggle="modal" data-target="#registrationModal">등록</button>
            <button class="btn btn-primary text-right" onclick="performAction('modification')">수정</button>
            <button class="btn btn-primary text-right" onclick="performAction('deletion')">삭제</button>
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

<script>
    function performAction(action) {
        // Implement your code for modification and deletion here
    }

    function submitRegistrationForm() {
        var formData = {
            category: $('#category').val(),
            quizInfo: $('#quizInfo').val()
            // Add other form fields as needed
        };

        $.ajax({
            type: 'POST',
            url: 'QuizRegistrationServlet', // URL to handle the form submission
            data: formData,
            success: function (response) {
                // Refresh the quiz list after successful registration
                $('#dataTable tbody').html(response);
                $('#registrationModal').modal('hide');
            },
            error: function (error) {
                // Handle errors, if any
                console.error('Error submitting the form: ' + error);
            }
        });
    }
</script>
