package com.nnlightctl.server;

public interface CommandServer {
    String sendCommand(String msg);
    void sendLightAdjustCommand(int percent);
    String webRequireMsg();
    void resetCommand();
    void configTerminalSendMsgPeriod(int period);
    void commandTerminalEleboxOn(Boolean terminalEleboxOn);
    String commandReadTerminalInfo();
}
