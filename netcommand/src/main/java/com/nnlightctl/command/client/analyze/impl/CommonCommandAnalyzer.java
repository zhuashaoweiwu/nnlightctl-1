package com.nnlightctl.command.client.analyze.impl;

import com.nnlightctl.command.client.analyze.CommandAnalyzer;
import com.nnlightctl.net.CommandData;

public class CommonCommandAnalyzer implements CommandAnalyzer {
    @Override
    public String analyze(CommandData command) {
        return command.toHexString();
    }
}
