package com.nnlight.netty.process.factory;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.process.impl.*;

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

                //命令层C5指令（设置定时发送参数）
            case (byte)0xc5:
                return c5;

                //命令层C6指令（控制柜断电/通电）
            case (byte)0xc6:
                return c6;

                //接收终端e0周期发送消息指令
            case (byte)0xe0:
                return e0;

                //命令层C8指令（读取终端信息）
            case (byte)0xc8:
                return c8;

                //终端应答指令
            case (byte)0x80:
                return e80;

                //命令层应答
            case (byte)0xb8:
                return b80;

                //命令层c7指令
            case (byte)0xc7:
                return c7;

                //命令层c9指令
            case (byte)0xc9:
                return c9;

                //终端f0指令
            case (byte)0xf0:
                return f0;

            // 命令层A0指令
            case (byte) 0xa0:
                return a0;
            // 终端D0指令
            case (byte) 0xd0:
                return d0;
            // 命令层A0指令
            case (byte) 0xa1:
                return a1;
            // 终端D1指令
            case (byte) 0xd1:
                return d1;
                //无控制码默认返回消息到上层命令客户端
                default:
                return commonProcess;
        }
    }

    private static final Process c1 = new C1Process();
    private static final Process c2 = new C2Process();
    private static final Process c4 = new C4Process();
    private static final Process c5 = new C5Process();
    private static final Process c6 = new C6Process();
    private static final Process e0 = new E0Process();
    private static final Process c8 = new C8Process();
    private static final Process e80 = new E80Process();
    private static final Process b80 = new B8Process();
    private static final Process c7 = new C7Process();
    private static final Process c9 = new C9Process();
    private static final Process f0 = new F0Process();
    private static final Process a0 = new A0Process();
    private static final Process d0 = new D0Process();
    private static final Process a1 = new A1Process();
    private static final Process d1 = new D1Process();
    private static final Process commonProcess = new CommonProcess();
}
