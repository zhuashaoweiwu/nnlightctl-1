package com.nnlightctl.mymessage.producer;

import com.nnlightctl.mymessage.MsgQuene;
import com.nnlightctl.net.CommandData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Produce {

    private Logger logger = LoggerFactory.getLogger(Produce.class);

    @Autowired
    private MsgQuene msgQuene;

    public void produce(CommandData commandData) {
        try {
            msgQuene.push(commandData);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
