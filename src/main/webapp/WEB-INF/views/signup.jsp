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
                            <form class="user">
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="userName" placeholder="이름 입력">
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" id="email" placeholder="이메일 입력">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user" id="password" placeholder="패스워드 입력">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user" id="repeatPassword" placeholder="패스워드 확인">
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

    <!-- Bootstrap core JavaScript -->
    <script src="/resources/static/bootstrap/jquery/jquery.min.js"></script>
    <script src="/resources/static/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/static/bootstrap/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages -->
    <script src="/resources/static/bootstrap/js/sb-admin-2.min.js"></script>
    <script src="/resources/static/js/account.js"></script>

</body>
</html>