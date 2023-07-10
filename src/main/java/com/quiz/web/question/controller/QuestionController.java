package com.quiz.web.question.controller;

import com.quiz.apps.common.CommonResponse;
import com.quiz.apps.question.model.Question;
import com.quiz.apps.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/java/question")
    public String javaQuestionPage() {

        return "javaQuestion";
    }

    @PostMapping("/question/java")
    @ResponseBody
    public CommonResponse questionJava() {
        CommonResponse commonResponse = new CommonResponse();

        List<Question> selectJavaQuestionList =  questionService.selectJavaQuestionList();
        commonResponse.setItems(selectJavaQuestionList);

        return commonResponse;


    }

}
