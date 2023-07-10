package com.quiz.apps.common;

import lombok.Data;

import java.util.List;

@Data
public class CommonResponse {

    private int code;
    private int status;
    private String message;
    private Object data;
    private List<?> items;

}
