package com.weatherserver;

import com.common.Result.Tuple;
import com.common.request.WeatherRequest;
import com.weatherdb.vo.WeatherView;

import java.util.List;

public interface ShowDataWeatherServer {
    Tuple.TwoTuple<List<WeatherView>,Integer> listWeather(WeatherRequest Request);

}
