package com.weatherdb.tranmessager.producer;

import com.netty.dto.CommandData;
import com.weatherdb.tranmessager.MessagerQuene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MsgProducer {
    @Autowired
    private MessagerQuene messagerQuene;

    public void Produce(CommandData commandData){
        try {
            messagerQuene.push(commandData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
