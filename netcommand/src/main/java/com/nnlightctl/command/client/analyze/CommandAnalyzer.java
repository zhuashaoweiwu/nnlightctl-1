package com.nnlightctl.command.client.analyze;

import com.nnlightctl.net.CommandData;

public interface CommandAnalyzer {
    String analyze(CommandData command);
}
