package com.quiz.web.question.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class QuestionController {


    @GetMapping("/java/question")
    public String javaQuestionPage() {

        return "javaQuestion";
    }
}
