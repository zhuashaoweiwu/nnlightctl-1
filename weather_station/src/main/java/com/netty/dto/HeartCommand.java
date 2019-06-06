package com.netty.dto;

import com.common.util.ByteConvert;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeartCommand {
    /**
     * 帧的起始符
     */
    private byte start0 = 0x68;
    /**
     * 地址域
     * 04 以太网透传网关
     */
    private byte[] addr ={(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x04};
    /**
     * 帧的起始符
     */
    private byte start1 = 0x68;
    /**
     * 控制码
     */
    private byte control= (byte) 0xE1;
    /**
     * 数据长度
     */
    private byte dataLength = (byte)0;
    /**
     * 心跳传来的mac地址
     */
    private byte[] data = new byte[0];
    /**
     * 效验码
     */
    private byte check;
    /**
     * 帧结束符
     */
    private byte end0 = 0x16;
    /**
     * 帧识别码
     */
    private byte[] end1 = new byte[] {(byte)0xFE, (byte)0xFD, (byte)0xFC, (byte)0xFB, (byte)0xFA, (byte)0xF9};
    private static final long serialVersionUID = 1L;

}
