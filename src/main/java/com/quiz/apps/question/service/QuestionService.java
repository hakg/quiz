package com.quiz.apps.question.service;

import com.quiz.apps.question.model.Answer;
import com.quiz.apps.question.model.Question;

import java.util.List;

public interface QuestionService {

    public Question selectJavaQuestion(Question question);

    public int selectCountJavaQuestion(Question question);

    public Answer selectAnswer(Answer answer);
}
