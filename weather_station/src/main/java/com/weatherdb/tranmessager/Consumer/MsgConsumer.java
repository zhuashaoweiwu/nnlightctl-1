package com.weatherdb.tranmessager.Consumer;

import com.netty.dto.CommandData;
import com.weatherdb.tranmessager.MessagerQuene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class MsgConsumer {

    @Autowired
    private MessagerQuene messagerQuene;

    private static final Logger logger= LoggerFactory.getLogger(MsgConsumer.class);


    public void consumer(){
        ExecutorService SingThreadExecutorService=Executors.newSingleThreadExecutor();
        SingThreadExecutorService.execute(new Runnable() {
            @Override
            public void run() {

                logger.info("------------------------消息被消费------------------");
                try {
                    CommandData dataCommand = messagerQuene.take();
                    System.err.print("接到消息**********"+dataCommand+"************");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }





}
