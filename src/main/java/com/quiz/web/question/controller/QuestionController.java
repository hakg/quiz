package com.quiz.web.question.controller;

import com.quiz.apps.common.CommonResponse;
import com.quiz.apps.question.model.Answer;
import com.quiz.apps.question.model.Question;
import com.quiz.apps.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question")
    public String javaQuestionPage() {

        return "question";
    }

    @GetMapping("/finishQuestion")
    public String javaQuestionFinishPage() {

        return "finishQuestion";
    }

    @GetMapping("/quizManage")
    public String quizManage(Model model) {
        List<Question> quizList = questionService.selectQuiz();
        model.addAttribute("quizList", quizList);

        return "quizManage";
    }

    @PostMapping("/quizInsert")
    @ResponseBody
    public String quizInsert(@ModelAttribute Question question) {
        questionService.insertQuestion(question);

        return "redirect:/quizManage";
    }

    @PostMapping("/question/java")
    @ResponseBody
    public CommonResponse questionJava(@ModelAttribute Question question) {
        CommonResponse commonResponse = new CommonResponse();

        Question selectJavaQuestion =  questionService.selectJavaQuestion(question);

        question.setNo(question.getNo());


        int count = questionService.selectCountQuestion(question);
        commonResponse.setData(selectJavaQuestion);
        commonResponse.setTotalCount(count);

        return commonResponse;


    }

    @PostMapping("/answer")
    @ResponseBody
    public CommonResponse giveAnswer(@ModelAttribute Answer answer) {
        CommonResponse commonResponse = new CommonResponse();

        String inputAnswer = answer.getInputAnswer().replaceAll("\\s", "");
        System.out.println(inputAnswer);

        Answer selectAnswer = questionService.selectAnswer(answer);
        int count = questionService.selectCountQuestion(answer);

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
        commonResponse.setTotalCount(count);

        return commonResponse;
    }

    @PostMapping("/answer/description")
    @ResponseBody
    public CommonResponse showAnswerDescription(@ModelAttribute Answer answer) {
        CommonResponse commonResponse = new CommonResponse();

        Answer selectAnswer = questionService.selectAnswer(answer);
        int count = questionService.selectCountQuestion(answer);

        commonResponse.setData(selectAnswer);
        commonResponse.setTotalCount(count);

        return commonResponse;
    }

}
