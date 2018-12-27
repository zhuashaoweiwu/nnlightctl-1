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

                //上层客户端发送升级固件指令
            case (byte)0xc3:
                return c3;

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

                //e1心跳包
            case (byte)0xe1:
                return e1;

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

                //终端校时
            case (byte)0xf1:
                return f1;

                //命令层终端高光电源模式
            case (byte)0xb2:
                return b2;

            // 命令层A0指令
            case (byte) 0xa0:
                return a0;
            // 终端D0指令
            case (byte) 0xd0:
                return d0;
            // 命令层A1指令
            case (byte) 0xa1:
                return a1;
            // 终端D1指令
            case (byte) 0xd1:
                return d1;
            // 命令层A2指令
            case (byte) 0xa2:
                return a2;
            // 终端D2指令
            case (byte) 0xd2:
                return d2;
            // 命令层A3指令
            case (byte) 0xa3:
                return a3;
            //终端D3指令
            case (byte) 0xd3:
                return d3;
            // 命令层A4指令
            case (byte) 0xa4:
                return a4;
            //终端D4指令
            case (byte) 0xd4:
                return d4;
            // 命令层A5指令
            case (byte) 0xa5:
                return a5;
            //终端D5指令
            case (byte) 0xd5:
                return d5;
            // 命令层A6指令
            case (byte) 0xa6:
                return a6;
            //终端D6指令
            case (byte) 0xd6:
                return d6;
            // 命令层A6指令
            case (byte) 0xa7:
                return a7;
            //终端D6指令
            case (byte) 0xd7:
                return d7;
                //modbus
            case (byte) 0x11:
                return c11;
                //无控制码默认返回消息到上层命令客户端
                default:
                return commonProcess;
        }
    }

    private static final Process c1 = new C1Process();
    private static final Process c2 = new C2Process();
    private static final Process c3 = new C3Process();
    private static final Process c4 = new C4Process();
    private static final Process c5 = new C5Process();
    private static final Process c6 = new C6Process();
    private static final Process e0 = new E0Process();
    private static final Process e1 = new E1Process();
    private static final Process c8 = new C8Process();
    private static final Process e80 = new E80Process();
    private static final Process b80 = new B8Process();
    private static final Process c7 = new C7Process();
    private static final Process c9 = new C9Process();
    private static final Process f0 = new F0Process();
    private static final Process f1 = new F1Process();
    private static final Process b2 = new B2Process();
    private static final Process a0 = new A0Process();
    private static final Process d0 = new D0Process();
    private static final Process a1 = new A1Process();
    private static final Process d1 = new D1Process();
    private static final Process a2 = new A2Process();
    private static final Process d2 = new D2Process();
    private static final Process a3 = new A3Process();
    private static final Process d3 = new D3Process();
    private static final Process a4 = new A4Process();
    private static final Process d4 = new D4Process();
    private static final Process a5 = new A5Process();
    private static final Process d5 = new D5Process();
    private static final Process a6 = new A6Process();
    private static final Process d6 = new D6Process();
    private static final Process a7 = new A7Process();
    private static final Process d7 = new D7Process();
    private static final Process c11 = new C11Process();
    private static final Process commonProcess = new CommonProcess();
}
