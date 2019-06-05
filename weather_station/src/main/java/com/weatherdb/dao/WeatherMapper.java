package com.weatherdb.dao;

import com.weatherdb.entity.LouverBox;

import java.util.List;

public interface WeatherMapper {
    /**
     * 查询天气气象总条数
     * @return
     */
    int selectByCount();
    /**
     * 查询天气气象的数据
     * @return
     */
    List<LouverBox> selectAll();


}
