package com.quiz.apps.menu.service;


import com.quiz.apps.menu.model.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public interface MenuService {

    public List<Menu> selectMenuList(Map<String, Object> map);

}
