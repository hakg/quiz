package com.quiz.apps.common;

import lombok.Data;

import java.util.List;

@Data
public class ResultJSON {

    private Object data;
    private List<?> items;
}
