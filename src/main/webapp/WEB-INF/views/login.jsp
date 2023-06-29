<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/static/css/login.css">
</head>
<body class="align">
  <div class="grid">
    <form action="/" method="post" class="form login">
      <header class="login__header">
        <h3 class="login__title">Login</h3>
      </header>
      <div class="login__body">
        <div class="form__field">
          <input type="email" placeholder="Email" required>
        </div>
        <div class="form__field">
          <input type="password" placeholder="Password" required>
        </div>
      </div>
      <footer class="login__footer">
        <input type="submit" value="Login">
        <p><span class="icon icon--info">?</span><a href="#">Forgot Password</a></p>
      </footer>
    </form>
  </div>
</body>
</html>
