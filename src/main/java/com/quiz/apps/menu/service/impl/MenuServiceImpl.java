package com.quiz.apps.menu.service.impl;

import com.quiz.apps.menu.mapper.MenuMapper;
import com.quiz.apps.menu.model.Menu;
import com.quiz.apps.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;

    @Override
    public List<Menu> selectMenuList(Map<String, Object> map) {
        return null;
    }
}
