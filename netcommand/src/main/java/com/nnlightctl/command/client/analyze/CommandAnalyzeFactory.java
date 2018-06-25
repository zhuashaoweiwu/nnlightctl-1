package com.nnlightctl.command.client.analyze;

import com.nnlightctl.command.client.analyze.impl.C1CommandAnalyze;
import com.nnlightctl.command.client.analyze.impl.CommonCommandAnalyzer;
import com.nnlightctl.command.client.analyze.impl.E0CommandAnalyze;

public class CommandAnalyzeFactory {
    public static CommandAnalyzer getCommandAnalyzer(byte control) {
        switch (control) {
            case (byte)0xc1:
                return c1CommandAnalyzer;

            case (byte)0xe0:
                return e0CommandAnalyzer;

                default:
                    return commonCommandAnalyzer;
        }
    }

    private static final CommandAnalyzer c1CommandAnalyzer = new C1CommandAnalyze();
    private static final CommandAnalyzer commonCommandAnalyzer = new CommonCommandAnalyzer();
    private static final CommandAnalyzer e0CommandAnalyzer = new E0CommandAnalyze();
}
