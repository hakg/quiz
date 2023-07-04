package com.quiz.apps.menu.model;

import lombok.Data;

import java.util.Date;

@Data
public class Menu {

    public String menuCode;
    public String menuName;
    public String menuGubun;
    public String parentMenuID;
}
