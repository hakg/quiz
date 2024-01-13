package com.quiz.apps.question.service.impl;

import com.quiz.apps.question.mapper.QuestionMapper;
import com.quiz.apps.question.model.Answer;
import com.quiz.apps.question.model.Question;
import com.quiz.apps.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Override
    public Question selectJavaQuestion(Question question) {
        return questionMapper.selectJavaQuestion(question);
    }

    @Override
    public int selectCountQuestion(Question question) {
        return questionMapper.selectCountQuestion(question);
    }

    @Override
    public Answer selectAnswer(Answer answer) {
        return questionMapper.selectAnswer(answer);
    }

    @Override
    public int insertQuestion(Question question) {
        return questionMapper.insertQuestion(question);
    }

    @Override
    public List<Question> selectQuiz() {
        return questionMapper.selectQuiz();
    }
}
