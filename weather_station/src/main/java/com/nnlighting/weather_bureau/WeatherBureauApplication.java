package com.nnlighting.weather_bureau;


import com.netty.dto.ChannelWarp;
import com.netty.hander.BindWeatherHander;
import com.netty.hander.Context;
import com.netty.process.WeatherProcess;
import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(scanBasePackages = "com")
@ComponentScan(value = "com")
@MapperScan("com.weatherdb.dao")
@EnableScheduling
public class WeatherBureauApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherBureauApplication.class, args);
    }


}
