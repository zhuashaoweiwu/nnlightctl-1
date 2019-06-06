package com.weatherdb.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WeatherView {
    private long id;

    private String gmtCreated;

    private String gmtUpdated;
    /**
     * 温度
     */
    private String temperature;
    /**
     * 湿度
     */
    private String humidity;
    /**
     * 风速
     */
    private String windSpeed;
    /**
     * 风向
     */
    private String windDriection;
    /**
     * 噪声
     */
    private String noise;

    private String pm10;
    /**
     * pm2.5
     */
    private String pm25;
    /**
     * 大气压力
     */
    private String atmosphericPressure;
    /**
     * 光照强度
     */
    private String lightIntensity;

    public WeatherView(){

    }


}
