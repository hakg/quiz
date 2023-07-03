package com.quiz.apps.menu.mapper;

import com.quiz.apps.menu.model.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuMapper {

    public List<Menu> selectMenuList(Map<String, Object> map);
}
