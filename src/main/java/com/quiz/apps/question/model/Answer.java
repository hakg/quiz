package com.quiz.apps.question.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Answer extends Question{
    private int answerId;
    private String answerDesc;
    private String answerKeyword;
    private String inputAnswer;
    private String insertId;
    private Timestamp insertDate;
    private String modifyId;
    private Timestamp modifyDate;
}
