package com.nnlightctl.net;

import com.nnlightctl.util.BytesHexStrTranslate;

import java.io.Serializable;

public class CommandData implements Serializable {
    public byte getStart0() {
        return start0;
    }

    public void setStart0(byte start0) {
        this.start0 = start0;
    }

    public byte[] getAddr() {
        return addr;
    }

    public void setAddr(byte[] addr) {
        this.addr = addr;
    }

    public byte getStart1() {
        return start1;
    }

    public void setStart1(byte start1) {
        this.start1 = start1;
    }

    public byte getControl() {
        return control;
    }

    public void setControl(byte control) {
        this.control = control;
    }

    public byte getDataLength() {
        return dataLength;
    }

    public void setDataLength(byte dataLength) {
        this.dataLength = dataLength;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte getCheck() {
        return check;
    }

    public void setCheck(byte check) {
        this.check = check;
    }

    public byte getEnd0() {
        return end0;
    }

    public void setEnd0(byte end0) {
        this.end0 = end0;
    }

    public byte[] getEnd1() {
        return end1;
    }

    public void setEnd1(byte[] end1) {
        this.end1 = end1;
    }

    private byte createCheck() {
        long sum = 0L;

        sum += this.start0;

        for (int i = 0; i < addr.length; ++i) {
            sum += addr[i];
        }

        sum += this.start1;
        sum += this.control;
        sum += this.dataLength;

        for (int i = 0; i < this.dataLength; ++i) {
            sum += this.data[i];
        }

        return (byte)sum;
    }

    public CommandData() {}

    public CommandData(int percent) {
        this.control = (byte)0xe2;
        this.dataLength = 1;
        this.data = new byte[1];
        this.data[0] = (byte)percent;
        this.check = createCheck();
    }

    /**
     * 生成命令的16进制字符串形式
     * @return
     */
    public String toHexString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.start0));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.addr));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.start1));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.control, this.dataLength));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.data));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.check, this.end0));
        stringBuilder.append(" ");
        stringBuilder.append(BytesHexStrTranslate.bytesToHexFun(this.end1));

        return stringBuilder.toString();
    }

    /**
     * 校验
     * @return
     */
    public boolean check() {
        byte check = createCheck();

        return this.check == check;
    }

    /***************************************************命令客户端指令********************************************/

    //字符型命令
    public CommandData(String command) {
        this.control = (byte)0xc1;
        byte[] strBytes = command.getBytes();
        this.dataLength = (byte)strBytes.length;
        this.data = new byte[strBytes.length];
        System.arraycopy(strBytes, 0, this.data, 0, strBytes.length);
        this.check = createCheck();
    }

    //灯光调节命令
    public CommandData(int percent, byte control) {
        this.control = control;
        this.dataLength = 1;
        this.data = new byte[1];
        this.data[0] = (byte)percent;
        this.check = createCheck();
    }

    /***************************************************命令客户端指令********************************************/

    private byte start0 = 0x68;
    private byte[] addr = new byte[6];
    private byte start1 = 0x68;
    private byte control;
    private byte dataLength;
    private byte[] data;
    private byte check;
    private byte end0 = 0x16;
    private byte[] end1 = new byte[] {(byte)0xFE, (byte)0xFD, (byte)0xFC, (byte)0xFB, (byte)0xFA, (byte)0xF9};
    private static final long serialVersionUID = 1L;
}