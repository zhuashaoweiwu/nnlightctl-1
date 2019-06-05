package com.weatherdb.tranmessager;

import com.netty.dto.CommandData;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class MessagerQuene {
    private BlockingQueue<CommandData> commandDataBlockingQueue = new LinkedBlockingQueue<>();

    public void push(CommandData commandData) throws InterruptedException {
        commandDataBlockingQueue.put(commandData);
    }

    public CommandData take() throws InterruptedException {
        return commandDataBlockingQueue.take();
    }
}
