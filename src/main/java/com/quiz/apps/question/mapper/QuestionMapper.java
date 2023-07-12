package com.quiz.apps.question.mapper;

import com.quiz.apps.question.model.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    public Question selectJavaQuestion(Question question);

}
