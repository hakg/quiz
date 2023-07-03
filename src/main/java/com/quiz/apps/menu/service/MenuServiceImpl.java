package com.quiz.apps.menu.service;

import com.quiz.apps.menu.mapper.MenuMapper;
import com.quiz.apps.menu.model.Menu;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;


    @Override
    public List<Menu> selectMenuList(Map<String, Object> map) {
        return null;
    }
}
