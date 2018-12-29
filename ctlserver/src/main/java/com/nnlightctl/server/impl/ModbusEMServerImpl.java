package com.nnlightctl.server.impl;

import com.nnlight.common.PropertiesUtil;
import com.nnlightctl.dao.EleboxMapper;
import com.nnlightctl.po.EleboxExample;
import com.nnlightctl.request.ModbusRequest;
import com.nnlightctl.server.CommandServer;
import com.nnlightctl.server.ModbusEMServer;
import com.nnlightctl.util.BytesHexStrTranslate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Properties;

@Service
public class ModbusEMServerImpl implements ModbusEMServer {

    private static final Logger log = LoggerFactory.getLogger(ModbusEMServerImpl.class);

    private final Properties properties;

    @Autowired
    private CommandServer commandServer;

    @Autowired
    private EleboxMapper eleboxMapper;

    public ModbusEMServerImpl() throws IOException {
        properties = PropertiesUtil.load("config/modbusDirective.properties");
    }

    @Override
    public String getInvokeModbusEMDirective(ModbusRequest request) {
        String netGateWayAddr = request.getNetway();

        //获取控制柜作为透传的实时realtimeUUID
        EleboxExample eleboxExample = new EleboxExample();
        EleboxExample.Criteria criteria = eleboxExample.createCriteria();
        criteria.andUidEqualTo(netGateWayAddr);

        EleboxExample.Criteria criteria1 = eleboxExample.createCriteria();
        criteria1.andNetworkAddrEqualTo(netGateWayAddr);
        eleboxExample.or(criteria1);

        String realtimeUUID = eleboxMapper.selectByExample(eleboxExample).get(0).getRealtimeUid();

        //获取指令对应的字节码
        String modbusDirectiveStr = StringUtils.isEmpty(request.getHexModbusDirective()) ?
                properties.getProperty(String.valueOf(request.getDirectiveType())) : request.getHexModbusDirective();
        if (StringUtils.isEmpty(modbusDirectiveStr)) {
            throw new RuntimeException("无法找到对应的Modbus指令");
        }


        return commandServer.invokeModbusDirective(realtimeUUID, BytesHexStrTranslate.toBytes(modbusDirectiveStr)).getOriginalPackageInfoHex();
    }
}
