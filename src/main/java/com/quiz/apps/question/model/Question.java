package com.quiz.apps.question.model;

import lombok.Data;

import java.util.Date;

@Data
public class Question {

    private int quizID;
    private String category;
    private String quizInfo;
    private String insertId;
    private Date insertDate;
    private String modifyId;
    private Date modifyDate;
    private int no;
}
