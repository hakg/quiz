function showQuestion(name,no) {

    console.log(name);
    console.log(no);

    if(name === '자바') {
        name = 'java';
    }

    var param = {
        "category" : name,
        "no" : no
    };

    $.ajax({
        type : 'POST',
        dataType : 'JSON',
        data : param,
        url : '/question/' + name,
        error:function() {
            console.log("error");
        },
        success: function(returnJSON) {

            var object = returnJSON.data;
            var totalCount = returnJSON.totalCount;

            $('#questionTitle').html(object.quizInfo);
            $('#questionTitle').attr('data-id', object.quizID);

            var width = ((object.quizID) * ((object.quizID) / totalCount)) * 100 + '%';

            $('.progress-bar').css('width', width);

        }

    });

}

function submitAnswer() {

    var exampleInputAnswer = $('#exampleInputAnswer').val();
    var quizID = $('#questionTitle').attr('data-id');


    var param = {
        "inputAnswer" : exampleInputAnswer,
        "quizID" : quizID
    }
    console.log(param);

    $.ajax({
            type : 'POST',
            dataType : 'JSON',
            data : param,
            url : '/answer',
            error:function() {
                console.log("error");
            },
            success: function(returnJSON) {
                console.log(returnJSON);
                var object = returnJSON.data;

                if(returnJSON.message == "correctAnswer") {
                    console.log("정답처리");
                    var no = parseInt(object.no) + 1;
                    //일단 하드코딩 어떻게 할지는 다시 생각해보자
                    showQuestion('자바',no);
                }

            }

        });

}

$('#answer').on('click', function() {
    submitAnswer();

});

/* ======================================================================================
 *  공통부분
 * ======================================================================================
 */
//초기 실행시 제일 먼저 실행하도록 하는 자바스크립트 실행문
//즉시 실행함수라고 보면 된다.
(function(){
    $('#exampleInputAnswer').on( 'keyup', function (e){
        $(this).css('height', 'auto');
        $(this).height(this.scrollHeight);
      });
      $('#exampleInputAnswer').keyup();
    //showQuestion();
})();