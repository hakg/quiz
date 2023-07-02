// 로그인 버튼을 클릭했을 때 실행되는 함수
function loginUser() {
  // 이메일과 패스워드 값을 가져옵니다.
  const email = $('#email').val();
  const password = $('#password').val();

  // 로그인 요청을 보냅니다.
  $.ajax({
    url: '/login',
    type: 'POST',
    data: {
      email: email,
      password: password
    },
    success: function(response) {
      // 요청이 성공하면 응답을 처리합니다.
      alert('로그인 성공');
      console.log(response); // 응답 데이터 출력 예시
      // 로그인 성공 후에 필요한 작업을 수행합니다.
    },
    error: function(error) {
      // 요청이 실패하면 에러를 처리합니다.
      console.error(error); // 에러 메시지 출력 예시
      // 에러 처리 로직을 추가합니다.
    }
  });
}

// 회원가입 완료 버튼을 클릭했을 때 실행되는 함수
function signupUser() {
  // 이름, 이메일, 패스워드 값을 가져옵니다.
  const userName = $('#userName').val();
  const email = $('#email').val();
  const password = $('#password').val();

  // 회원가입 요청을 보냅니다.
  $.ajax({
    url: '/signup',
    type: 'POST',
    data: {
      userName: userName,
      email: email,
      password: password
    },
    success: function(response) {
      // 요청이 성공하면 응답을 처리합니다.
      console.log(response); // 응답 데이터 출력 예시
      // 회원가입 성공 후에 필요한 작업을 수행합니다.
    },
    error: function(error) {
      // 요청이 실패하면 에러를 처리합니다.
      console.error(error); // 에러 메시지 출력 예시
      // 에러 처리 로직을 추가합니다.
    }
  });
}

// 로그인 버튼에 이벤트 리스너를 추가합니다.
$('#loginBtn').on('click', loginUser);
// 회원가입 완료 버튼에 이벤트 리스너를 추가합니다.
$('#signUpBtn').on('click', signupUser);
