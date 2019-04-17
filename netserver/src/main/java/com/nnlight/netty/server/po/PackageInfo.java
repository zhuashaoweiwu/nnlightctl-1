package com.nnlight.netty.server.po;

import java.io.Serializable;
import java.net.InetSocketAddress;

public class PackageInfo implements Serializable {
    public static final byte SEPAPATOR = (byte)':';

    private byte start;
    private byte[] source = new byte[6];
    private byte[] data;
    private byte end;
    private InetSocketAddress inetAddress;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public InetSocketAddress getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(InetSocketAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    public PackageInfo(byte[] data) {
        this.start = 0x68;
        this.end = 0x48;
        this.source = "B01001".getBytes();
        this.data = data;
    }

    public PackageInfo() {

    }

    public byte getStart() {
        return start;
    }

    public void setStart(byte start) {
        this.start = start;
    }

    public byte[] getSource() {
        return source;
    }

    public void setSource(byte[] source) {
        this.source = source;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte getEnd() {
        return end;
    }

    public void setEnd(byte end) {
        this.end = end;
    }
}
