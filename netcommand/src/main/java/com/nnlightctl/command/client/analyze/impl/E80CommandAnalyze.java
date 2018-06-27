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
        }

        return stringBuilder.toString();
    }
}
