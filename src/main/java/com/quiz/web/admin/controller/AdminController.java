package com.quiz.web.admin.controller;

import com.quiz.apps.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final QuestionService questionService;


}