<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>QuizApp 로그인</title>
    
    <!-- Custom fonts for this template-->
    <link href="/resources/static/bootstrap/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/static/bootstrap/css/sb-admin-2.min.css" rel="stylesheet" type="text/css">

    <!-- 자바스크립트 기본 코어 모듈 -->
    <jsp:include page="common/include_common.jsp"/>
</head>

<body class="bg-gradient-primary">
    <div class="container">
        <!-- Outer Row -->
        <div class="row justify-content-center">
            <div class="col-xl-10 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                                    </div>
                                    <form class="user" method="post" action="/loginProcess" >
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                id="userId" name="userId" aria-describedby="userIdHelp"
                                                required="true" placeholder="사용자아이디 입력(이메일 또는 핸드폰)">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="password" name="password" required="true" placeholder="패스워드 입력">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">로그인정보 저장</label>
                                            </div>
                                        </div>
                                        <button id="loginBtn" type="submit" class="btn btn-primary btn-user btn-block">로그인</div>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="forgot-password.html">비밀번호 찾기</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="/signup" >회원가입</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>