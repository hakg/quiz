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
      password: $('#password').val()
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

// 로그인 버튼에 이벤트 리스너를 추가합니다.
//$('#loginBtn').on('click', loginUser);
// 회원가입 완료 버튼에 이벤트 리스너를 추가합니다.
$('#signUpBtn').on('click', signupUser);
