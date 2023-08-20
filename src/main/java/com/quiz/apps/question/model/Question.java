package com.quiz.apps.question.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Question {

    private int quizID;
    private String category;
    private String quizInfo;
    private String insertId;
    private Timestamp insertDate;
    private String modifyId;
    private Timestamp modifyDate;
    private int no;
}
