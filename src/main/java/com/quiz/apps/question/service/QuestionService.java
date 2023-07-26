package com.quiz.apps.question.service;

import com.quiz.apps.question.model.Answer;
import com.quiz.apps.question.model.Question;

import java.util.List;

public interface QuestionService {

    Question selectJavaQuestion(Question question);

    int selectCountQuestion(Question question);

    Answer selectAnswer(Answer answer);

    int insertQuestion(Question question);
}
