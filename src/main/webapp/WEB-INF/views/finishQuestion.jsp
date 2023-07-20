<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<style>
    .custom-button {
        display: inline-block;
        color: #fff;
        background-color: #4e73df;
        border: none;
        padding: 8px;
        border-radius: 6px;
        font-size: 15px;
        font-weight: bold;
    }
</style>
</head>

<div class="card mb-4 py-3 border-left-primary" style="margin-top: 100px;">
    <div id="questionFinishTitle" class="card-body" style="text-align: center;">
            문제 제출이 완료 되었습니다.
    </div>

</div>

<div style=" text-align: center; margin-top: 30px;">
    	<button id="return" class="custom-button" style="display: inline-block; ">돌아가기</button>
    </div>

<script type="text/javascript">

    $(document).ready(function() {

        var name = $("#nameHidden").val();
        var url = '';

        if(name === '자바') {
            url = '/question';
        }

       $('#return').on('click', function() {
           $('#mainContent').load(url);
       });
    });


</script>











