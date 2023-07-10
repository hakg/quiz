package com.quiz.apps.question.model;

import lombok.Data;

import java.util.Date;

@Data
public class Question {

    public int quizID;
    public String category;
    public String quizInfo;
    public String insertId;
    public Date insertDate;
    public String modifyId;
    public Date modifyDate;
}
