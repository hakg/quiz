// 로그인 버튼을 클릭했을 때 실행되는 함수
//function loginUser() {
//  // 이메일과 패스워드 값을 가져옵니다.
//  // 폼 데이터 가져오기
//  const formData = {
//      userId: $('#userId').val(),
//      password: $('#password').val()
//  };
//
//  // 로그인 요청을 보냅니다.
//  $.ajax({
//    url: '/loginProcess',
//    type: 'POST',
//    contentType: 'application/json', // 요청 본문의 컨텐츠 타입
//    data: JSON.stringify({userId: formData.userId, password: formData.password}), // 폼 데이터를 JSON 문자열로 변환, // 폼 데이터를 JSON 문자열로 변환
//    success: function(response) {
//        if (response.code == "200") {
//            // 정상 처리 된 경우
//            window.location.href = '/index'; // 로그인 성공 후 인덱스 페이지로 리다이렉션
////            window.location = response.item.url;	//이전페이지로 돌아가기
//        } else {
//            alert(response.message);
//        }
//    },
//    error: function(error) {
//      // 요청이 실패하면 에러를 처리합니다.
//      console.error(error);
//    }
//  });
//}

// 회원가입 완료 버튼을 클릭했을 때 실행되는 함수
function signupUser() {
  // 이름, 이메일, 패스워드 값을 가져옵니다.
  const formData = {
      userName: $('#userName').val(),
      userId: $('#userId').val(),
      password: $('#password').val(),
      repeatPassword: $('#repeatPassword').val()
  }

  // 정규표현식 패턴
  const nameRegex = /^[가-힣]{2,4}$/; // 이름은 한글만 허용
  const emailRegex = /^[a-z0-9\.\-_]+@([a-z0-9\-]+\.)+[a-z]{2,6}$/; // 이메일 형식 체크
  const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/; // 패스워드는 최소 8자 이상, 숫자,문자,특문 포함

  if (!nameRegex.test(formData.userName)) {
    alert('올바른 이름을 입력해주세요.');
    userName.focus();
    return;
  }
  if (!emailRegex.test(formData.userId)) {
    alert('올바른 이메일 주소를 입력해주세요.');
    userId.focus();
    return;
  }
  if (!passwordRegex.test(formData.password)) {
    alert('올바른 패스워드를 입력해주세요.\n패스워드는 최소 8자 이상, 숫자, 문자, 특문 포함해야 합니다.');
    password.focus();
    return;
  }
  if (formData.password != formData.repeatPassword) {
    alert('패스워드를 확인해주세요.');
    repeatPassword.focus();
    return;
  }

  // 회원가입 요청을 보냅니다.
  $.ajax({
    url: '/signup',
    type: 'POST',
    contentType: 'application/json', // 요청 본문의 컨텐츠 타입
    data: JSON.stringify(formData), // 폼 데이터를 JSON 문자열로 변환
    success: function(response) {
        if (response.code == 200) {
            // 정상 처리 된 경우
            alert(response.message);
            window.location.href = '/login'; // 회원가입 성공 후 로그인 페이지로 리다이렉션
        } else {
            alert(response.message);
            $("#user")[0].reset();
        }
    },
    error: function(error) {
      // 요청이 실패하면 에러를 처리합니다.
      console.error(error); // 에러 메시지 출력 예시
    }
  });
}

// 회원정보 수정 완료 버튼을 클릭했을 때 실행되는 함수
function updateUser() {
  // 이름, 이메일, 패스워드 값을 가져옵니다.
  const formData = {
      userName: $('#userName').val(),
      userId: $('#userId').val(),
      password: $('#password').val(),
      repeatPassword: $('#repeatPassword').val()
  }

  // 정규표현식 패턴
  const nameRegex = /^[가-힣]{2,4}$/; // 이름은 한글만 허용
  const passwordRegex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/; // 패스워드는 최소 8자 이상, 숫자,문자,특문 포함

//  console.log(userName);
  console.log(formData.userName);
  if (!nameRegex.test(userName)) {
    alert('올바른 이름을 입력해주세요.');
    userName.focus();
    return;
  }

  if (password != '' || repeatPassword != '') {
      if (!passwordRegex.test(formData.password)) {
        alert('올바른 패스워드를 입력해주세요.\n패스워드는 최소 8자 이상, 숫자, 문자, 특문 포함해야 합니다.');
        password.focus();
        return;
      }

      if (formData.password != formData.repeatPassword) {
        alert('패스워드를 확인해주세요.');
        repeatPassword.focus();
        return;
      }
  }

  // 회원가입 요청을 보냅니다.
  $.ajax({
    url: '/account/update',
    type: 'POST',
    contentType: 'application/json', // 요청 본문의 컨텐츠 타입
    data: JSON.stringify(formData), // 폼 데이터를 JSON 문자열로 변환
    success: function(response) {
        if (response.code == 200) {
            // 정상 처리 된 경우
            alert(response.message);// 회원정보 수정 후 로그인 페이지로 리다이렉션
            location.reload();
        } else {
            alert(response.message);
        }
    },
    error: function(error) {
      // 요청이 실패하면 에러를 처리합니다.
      console.error(error); // 에러 메시지 출력 예시
    }
  });
}

// 로그인 버튼에 이벤트 리스너를 추가합니다.
//$('#loginBtn').on('click', loginUser);
// 회원가입 완료 버튼에 이벤트 리스너를 추가합니다.
$('#signUpBtn').on('click', signupUser);
// 회원정보 수정 완료 버튼 이벤트
$('#accountUpdateBtn').on('click', updateUser);
