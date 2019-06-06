package com.weatherserver.impl;

import com.common.Result.Tuple;
import com.common.request.WeatherRequest;
import com.github.pagehelper.PageHelper;
import com.weatherdb.dao.WeatherMapper;
import com.weatherdb.entity.LouverBox;
import com.weatherdb.vo.WeatherView;
import com.weatherserver.ShowDataWeatherServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ShowDataWeatherServerImpl implements ShowDataWeatherServer {

    @Autowired
    private WeatherMapper weatherMapper;
    @Override
    public Tuple.TwoTuple<List<WeatherView>, Integer> listWeather(WeatherRequest request) {
        //总条数
        int total=weatherMapper.selectByCount();
        //分页
        PageHelper.startPage(request.getPageNumber(),request.getPageSize());
        //得到气象数据
        List<LouverBox> louverBoxes = weatherMapper.selectAll();

        Tuple.TwoTuple<List<WeatherView>,Integer> twoTuple=new Tuple.TwoTuple<>();

        List<WeatherView> viewList=new ArrayList<>(12);
        for (LouverBox louverBox : louverBoxes) {
            WeatherView weatherView=new WeatherView();
            weatherView.setHumidity(louverBox.getHumidity());
            weatherView.setNoise(louverBox.getNoise());
            weatherView.setTemperature(louverBox.getTemperature());
            weatherView.setWindSpeed(louverBox.getWindSpeed());
            weatherView.setWindDriection(louverBox.getWindDriection());
            weatherView.setPm10(louverBox.getPm10());
            weatherView.setPm25(louverBox.getPm25());
            weatherView.setId(louverBox.getId());
            viewList.add(weatherView);
        }
        twoTuple.setFirst(viewList);
        twoTuple.setSecond(total);
        return twoTuple;
    }
}
