package com.quiz.apps.menu.model;

import lombok.Data;

import java.util.Date;

@Data
public class Menu {

    private String menuCode;
    private String menuName;
    private String menuGubun;
    private String parentMenuID;
    private String menuUrl;
    private String submenuName;
}
