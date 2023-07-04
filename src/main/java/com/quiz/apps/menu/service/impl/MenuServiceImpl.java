package com.quiz.apps.menu.service.impl;

import com.quiz.apps.menu.mapper.MenuMapper;
import com.quiz.apps.menu.model.Menu;
import com.quiz.apps.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    public MenuMapper menuMapper;

    @Override
    public List<Menu> selectMenuList() {
        return menuMapper.selectMenuList();
    }
}
