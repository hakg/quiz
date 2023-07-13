package com.quiz.apps.question.model;

import lombok.Data;

import java.util.Date;

@Data
public class Answer extends Question{
    private int answerId;
    private String answerDesc;
    private String answerKeyword;
    private String inputAnswer;
    private String insertId;
    private Date insertDate;
    private String modifyId;
    private Date modifyDate;
}
