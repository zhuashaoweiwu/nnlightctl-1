package com.nnlight.netty.process.factory;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.process.impl.C1Process;
import com.nnlight.netty.process.impl.C2Process;
import com.nnlight.netty.process.impl.C4Process;
import com.nnlight.netty.process.impl.CommonProcess;

public class ProcessFactory {
    public static Process getProcess(byte control) {
        switch (control) {
            //转换上层命令客户端指令
            case (byte) 0xc1:
                return c1;

                //上层客户端发送调光指令
            case (byte) 0xc2:
                return c2;

                //重启复位指令
            case (byte)0xc4:
                return c4;

                //无控制码默认返回消息到上层命令客户端
                default:
                return commonProcess;
        }
    }

    private static final Process c1 = new C1Process();
    private static final Process c2 = new C2Process();
    private static final Process c4 = new C4Process();
    private static final Process commonProcess = new CommonProcess();
}
