function showQuestion(name) {
    console.log(name);

    $.ajax({
        type : 'POST',
        dataType : 'JSON',
        url : '/question/' + name,
        error:function() {
            console.log("error");
        },
        success: function(returnJSON) {


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

    //showQuestion();
})();