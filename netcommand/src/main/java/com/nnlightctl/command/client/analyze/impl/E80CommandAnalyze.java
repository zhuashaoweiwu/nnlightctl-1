package com.nnlightctl.command.client.analyze.impl;

import com.nnlightctl.command.client.analyze.CommandAnalyzer;
import com.nnlightctl.net.CommandData;

public class E80CommandAnalyze implements CommandAnalyzer {

    @Override
    public String analyze(CommandData command) {
        byte originalCommand = command.getData()[0];

        StringBuilder stringBuilder = new StringBuilder();

        switch (originalCommand) {

            case (byte)0xe8:
                stringBuilder.append(command.toHexString());
                break;

            case (byte)0xe2:
                stringBuilder.append("调光指令E2返回结果：");
                stringBuilder.append(command.toHexString());
                break;

            case (byte)0xe4:
                stringBuilder.append("重启/复位指令E4返回结果：");
                stringBuilder.append(command.toHexString());
                break;

            case (byte)0xe5:
                stringBuilder.append("设置定时发送参数指令E5返回结果：");
                stringBuilder.append(command.toHexString());
                break;

            case (byte)0xe6:
                stringBuilder.append("控制柜断电/通电指令E6返回结果：");
                stringBuilder.append(command.toHexString());
                break;

            case (byte)0xe7:
                stringBuilder.append("设置任务开关策略指令E7返回结果：");
                stringBuilder.append(command.toHexString());
                break;

        }

        return stringBuilder.toString();
    }
}
