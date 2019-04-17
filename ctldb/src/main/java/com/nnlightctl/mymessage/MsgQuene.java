package com.nnlightctl.mymessage;

import com.nnlightctl.net.CommandData;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class MsgQuene {
    private BlockingQueue<CommandData> commandDataBlockingQueue = new LinkedBlockingQueue<>();

    public void push(CommandData commandData) throws InterruptedException {
        commandDataBlockingQueue.put(commandData);
    }

    public CommandData take() throws InterruptedException {
        return commandDataBlockingQueue.take();
    }
}
