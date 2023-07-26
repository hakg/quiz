package com.quiz.apps.question.mapper;

import com.quiz.apps.question.model.Answer;
import com.quiz.apps.question.model.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    Question selectJavaQuestion(Question question);

    int selectCountQuestion(Question question);

    Answer selectAnswer(Answer answer);

    int insertQuestion(Question question);
}
