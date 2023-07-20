function showQuestion(name,no) {

    $('#exampleInputAnswer').val('');

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

            var width = ((object.quizID) * ((object.quizID) / totalCount)) * 100 + '%';

            $('#questionTitle').html(object.quizInfo);
            $('#questionTitle').attr('data-id', object.quizID);
            $('#questionTitle').attr('data-category', object.category);

            $('.progress-bar').css('width', width);

        }

    });

}

function submitAnswer() {

    var exampleInputAnswer = $('#exampleInputAnswer').val();
    var quizID = $('#questionTitle').attr('data-id');
    var category = $('#questionTitle').attr('data-category');


    var param = {
        "inputAnswer" : exampleInputAnswer,
        "quizID" : quizID,
        "category" : category
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
                var object = returnJSON.data;
                var totalCount = returnJSON.totalCount;

                if(returnJSON.message == "correctAnswer") {

                    if(object.no === totalCount) {
                        $('#mainContent').load('finishQuestion');
                    } else {
                        var no = parseInt(object.no) + 1;
                        showQuestion(object.category,no);
                    }

                } else {
                    console.log("정답이 틀렸습니다.");
                }

            }

        });

}

$('#answer').on('click', function() {
    submitAnswer();

});

/*$('#return').on('click', function() {
    console.log('1');
    $('#mainContent').load('/question');
});*/

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