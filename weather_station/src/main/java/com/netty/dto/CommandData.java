package com.netty.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CommandData {
    /**
     * 地址码
     * 0x01  风速
     * 0x02  风向
     * 0x03 温度和湿度
     * 0x04  噪声
     * 0x05  pm2.5和pm10
     */
    private byte addr;

    /**
     * 功能码
     * 0x03
     */
    private byte function=0x03;

    /**
     *  数据起始地址
     *
     */
    private  byte[] startAddr=new byte[]{(byte)0x00,(byte)0x00};

    /**
     * 数据长度
     */
    private byte[] length=new byte[2];

    private static final byte[] singleLength=new byte[]{(byte)0x00,(byte)0x01};

    /**
     * 双数据数据
     */
    private static final byte[] doubleLength=new byte[]{(byte)0x00,(byte)0x02};

    /**
     *  错误效验码
     */
    private byte[] CRCCode=new byte[2];

    /**
     *  有效字节数
     */
    private byte validBytes;

    /**
     *
     */
    private byte[] data=new byte[0];


    public CommandData(byte addr){
        switch (addr){
            /**
             * 风速
             */
            case (byte)0x01:
                //地址码
                this.setAddr((byte)0x01);
                this.setFunction((byte)0x03);
                //数据长度
                this.setLength(doubleLength);
                //效验位
                byte[] checkBitA=new byte[]{(byte) (0xC4 & 0xff),(byte)0x0B};
                this.setCRCCode(checkBitA);
                break;
            /**
             * 风向
             */
            case (byte)0x02:
                //地址码
                this.setAddr((byte)0x02);
                //单数据长度
                this.setLength(singleLength);
                //效验码
                byte[] checkBitB=new byte[]{(byte)0xC4,(byte)0x38};
                this.setCRCCode(checkBitB);
                break;
            /**
             * 温湿度
             */
            case (byte)0x03:
                //地址码
                this.setAddr((byte)0x03);
                //双数据长度
                this.setLength(doubleLength);
                //效验位
                byte[] checkBitC=new byte[]{(byte)0xC5,(byte)0xE9};
                this.setCRCCode(checkBitC);
                break;
            /**
             * 噪声
             */
            case (byte)0x04:
                //地址码
                this.setAddr((byte)0x04);
                //单数据长度
                this.setLength(singleLength);
                //效验位
                byte[] checkBitD=new byte[]{(byte)0xC4,(byte)0x5E};
                this.setCRCCode(checkBitD);
                break;
            /**
             * pm2.5,pm10
             */
            case (byte)0x05:
                //地址码
                this.setAddr((byte) 0x05);
                //双数据
                this.setLength(doubleLength);
                //效验位
                byte[] checkBitE=new byte[]{(byte)0xC5,(byte)0x8F};
                this.setCRCCode(checkBitE);
                break;
            /**
             *  大气压强
             */
            case (byte)0x06:
                //地址码
                this.setAddr((byte)0x06);
                //单数据长度
                this.setLength(singleLength);
                //效验位
                byte[] checkBitF=new byte[]{(byte)0x85,(byte)0xBD};
                this.setCRCCode(checkBitF);
                break;
            /**
             * 询问光照
             */
            case (byte)0x07:
                this.setAddr((byte)0x07);
                this.setLength(doubleLength);
                byte[] checkBitG=new byte[]{(byte)0xC4,(byte)0x6D};
                this.setCRCCode(checkBitG);
                break;
            default:
                System.out.println("获取信息有误");
        }

    }
    public CommandData(){}

}
