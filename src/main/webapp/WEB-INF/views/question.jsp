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

<div style=" text-align: right;">
	<button id="showAnswer" class="custom-button" style="display: inline-block; " data-toggle="modal" data-target="#showAnswerModal">정답 보기</button>
</div>

<div class="card mb-4 py-3 border-left-primary" style="margin-top: 50px;">
    <div id="questionTitle" class="card-body" style="text-align: center;" data-id="" data-category="">

    </div>
</div>

<textarea type="text" class="form-control form-control-user" id="exampleInputAnswer"  placeholder="정답을 적어주세요." style="margin-top: 30px;resize: none;box-sizing: border-box"></textarea>

<div style=" text-align: center; margin-top: 30px;">
	<button id="answer" class="custom-button" style="display: inline-block; ">정답 제출</button>
</div>

<div class="progress mb-4" style="margin-top: 150px;">
    <div class="progress-bar" role="progressbar" style="width: 50%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
</div>

    <div class="modal fade" id="showAnswerModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">

                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">문제 정답</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body" id="showDescription"></div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">닫기</button>
                </div>
            </div>
        </div>
    </div>
<script src="/resources/static/js/question.js"></script>

<script type="text/javascript">

    $(document).ready(function() {

        var name = $("#nameHidden").val();
        showQuestion(name,1);
    });


</script>






