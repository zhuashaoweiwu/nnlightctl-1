package com.weatherserver.impl;

import com.common.util.ThreadPoolHelper;
import com.netty.hander.Context;
import com.weatherserver.SendCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class SendCommandImpl implements SendCommand {

    @Resource
    private Context context;


    @Value("${tcp.url}")
    private String url;

    @Value("${tcp.port}")
    private int port;

    public SendCommandImpl(){

        ThreadPoolExecutor threadPoolExecutor = ThreadPoolHelper.commandExecutor();

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {

                } catch (Exception e) {
                    //重新连接
                    ScheduledExecutorService executorService=Executors.newSingleThreadScheduledExecutor();
                    executorService.scheduleAtFixedRate(new Runnable() {
                        @Override
                        public void run() {
                            try {

                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    },3,3, TimeUnit.SECONDS);
                }
            }
        });

    }





    @Override
    public void ACommand(byte addr) {
        context.sendMessage(addr);
    }
}
