package com.quiz.apps.question.service.impl;

import com.quiz.apps.question.mapper.QuestionMapper;
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
    public List<Question> selectJavaQuestionList() {
        return questionMapper.selectJavaQuestionList();
    }
}
