function showQuestion(name,no) {

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

            $('#questionTitle').html(object.quizInfo);

        }

    });

}


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