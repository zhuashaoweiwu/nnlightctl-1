package com.nnlightctl.command.client.analyze.impl;

import com.nnlightctl.command.client.analyze.CommandAnalyzer;
import com.nnlightctl.net.CommandData;

import java.nio.charset.Charset;

public class C1CommandAnalyze implements CommandAnalyzer {
    @Override
    public String analyze(CommandData command) {
        return new String(command.getData(), Charset.forName("UTF-8"));
    }
}
