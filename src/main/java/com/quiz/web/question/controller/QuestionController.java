package com.quiz.web.question.controller;

import com.quiz.apps.common.CommonResponse;
import com.quiz.apps.question.model.Answer;
import com.quiz.apps.question.model.Question;
import com.quiz.apps.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question")
    public String javaQuestionPage() {

        return "question";
    }

    @PostMapping("/question/java")
    @ResponseBody
    public CommonResponse questionJava(@ModelAttribute Question question) {
        CommonResponse commonResponse = new CommonResponse();

        Question selectJavaQuestion =  questionService.selectJavaQuestion(question);
        commonResponse.setData(selectJavaQuestion);

        return commonResponse;


    }

    @PostMapping("/answer")
    @ResponseBody
    public CommonResponse giveAnswer(@ModelAttribute Answer answer) {
        CommonResponse commonResponse = new CommonResponse();

        String inputAnswer = answer.getInputAnswer().replaceAll("\\s", "");
        System.out.println(inputAnswer);

        Answer selectAnswer = questionService.selectAnswer(answer);
        String answerKeyword = selectAnswer.getAnswerKeyword();
        int index = 0;
        String[] splitKeywords = answerKeyword.split(";");

        for (String keyword : splitKeywords) {
            if (inputAnswer.contains(keyword)) {
                index++;

            }
        }


        if(index == splitKeywords.length) {
            commonResponse.setMessage("correctAnswer");
        } else {
            commonResponse.setMessage("incorrectAnswer");
        }
        commonResponse.setData(selectAnswer);

        return commonResponse;
    }

}
