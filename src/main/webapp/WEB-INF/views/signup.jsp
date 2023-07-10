<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>QuizApp 회원가입</title>

    <!-- Custom fonts for this template-->
    <link href="/resources/static/bootstrap/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/static/bootstrap/css/sb-admin-2.min.css" rel="stylesheet"  type="text/css">

    <!-- 자바스크립트 기본 코어 모듈 -->
    <jsp:include page="common/include_common.jsp"/>
</head>

<body class="bg-gradient-primary">
    <div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">신규 회원가입</h1>
                            </div>
                            <form class="user" id="user">
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="userName" required="true" placeholder="이름 입력(2자~4자)">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="userId" required="true" placeholder="사용자아이디 입력(이메일)">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user" id="password" required="true" placeholder="패스워드 입력(최소8자 숫자,문자,특문 포함)">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user" id="repeatPassword" required="true"  placeholder="패스워드 확인(최소8자 숫자,문자,특문 포함)">
                                    </div>
                                </div>
                                <div id="signUpBtn" class="btn btn-primary btn-user btn-block">회원가입 완료</div>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">비밀번호 찾기</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="/login">로그인</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- event JavaScript -->
    <script src="/resources/static/js/account.js"></script>

</body>
</html>