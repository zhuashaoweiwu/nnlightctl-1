package com.Controller;


import com.common.Result.JsonResult;
import com.common.Result.Tuple;
import com.common.request.WeatherRequest;
import com.weatherdb.vo.WeatherView;
import com.weatherserver.ShowDataWeatherServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/weather")
public class WeatherController extends BaseController{
    @Autowired
    private ShowDataWeatherServer showDataServer;

    @RequestMapping("showdata")
    public String ShowWeather(WeatherRequest Request){
        Tuple.TwoTuple<List<WeatherView>, Integer> twoTuple = showDataServer.listWeather(Request);
        JsonResult jsonResult=JsonResult.getSuccess();
        jsonResult.setData(twoTuple.getFirst());
        jsonResult.setTotal(twoTuple.getSecond());
        return toJson(jsonResult);

    }
    @RequestMapping("/test")
    public String test(){
        return "hello";
    }
}
