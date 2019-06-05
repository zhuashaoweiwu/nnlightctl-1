package com.common.util;

import lombok.Data;

@Data
public class Msg {
    /**
     * 服务器下发的策略
     */
    private byte[] command;
    /**
     * 服务器返回的信息
     */
    private byte[] data;

}
