package com.nnlightctl.server.impl;

import com.nnlight.common.ByteConvert;
import com.nnlight.common.PropertiesUtil;
import com.nnlight.common.QuartzUtil;
import com.nnlightctl.dao.EleboxMapper;
import com.nnlightctl.dao.EleboxVolEleRecordMapper;
import com.nnlightctl.kafka.util.DataTransferUtil;
import com.nnlightctl.po.Elebox;
import com.nnlightctl.po.EleboxExample;
import com.nnlightctl.po.EleboxVolEleRecord;
import com.nnlightctl.request.ModbusRequest;
import com.nnlightctl.server.CommandServer;
import com.nnlightctl.server.ModbusEMServer;
import com.nnlightctl.util.BytesHexStrTranslate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class ModbusEMServerImpl implements ModbusEMServer {

    private static final Logger log = LoggerFactory.getLogger(ModbusEMServerImpl.class);

    private final Properties properties;

    @Autowired
    private CommandServer commandServer;

    @Autowired
    private EleboxMapper eleboxMapper;

    @Autowired
    private EleboxVolEleRecordMapper eleboxVolEleRecordMapper;

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

    @PostConstruct
    public void startScanEleboxModbusEM() {
        QuartzUtil.addJob(() -> {
            try {
                //获取全部控制柜
                List<Elebox> eleboxList = eleboxMapper.selectByExample(new EleboxExample());
                //针对每个控制柜，通过电表获取电能数据
                for (Elebox elebox : eleboxList) {
                    try {
                        String realtimeUUID = elebox.getRealtimeUid();
                        if (StringUtils.isEmpty(realtimeUUID)) {
                            continue;
                        }

                        EleboxVolEleRecord eleboxVolEleRecord = new EleboxVolEleRecord();

                        //A电压
                        String modbusDirectiveForAVoltage = properties.getProperty("3");
                        String responseHexForAVoltage = commandServer.invokeModbusDirective(realtimeUUID, BytesHexStrTranslate.toBytes(modbusDirectiveForAVoltage)).
                                getOriginalPackageInfoHex();
                        String responseHexForAVoltageValue = DataTransferUtil.transToModbusResponseValue(responseHexForAVoltage);
                        int AVoltageValue = ByteConvert.bytesToUshort(BytesHexStrTranslate.
                                toBytes(responseHexForAVoltageValue.substring(0, responseHexForAVoltageValue.length() / 2)));
                        eleboxVolEleRecord.setaVoltage(
                                new BigDecimal(String.valueOf(AVoltageValue)).
                                        divide(new BigDecimal("10"), 1, BigDecimal.ROUND_UNNECESSARY).toString());

                        //B电压
                        String modbusDirectiveForBVoltage = properties.getProperty("4");
                        String responseHexForBVoltage = commandServer.invokeModbusDirective(realtimeUUID, BytesHexStrTranslate.toBytes(modbusDirectiveForBVoltage)).
                                getOriginalPackageInfoHex();
                        String responseHexForBVoltageValue = DataTransferUtil.transToModbusResponseValue(responseHexForBVoltage);
                        int BVoltageValue = ByteConvert.bytesToUshort(BytesHexStrTranslate.
                                toBytes(responseHexForBVoltageValue.substring(0, responseHexForBVoltageValue.length() / 2)));
                        eleboxVolEleRecord.setbVoltage(
                                new BigDecimal(String.valueOf(BVoltageValue)).
                                        divide(new BigDecimal("10"), 1, BigDecimal.ROUND_UNNECESSARY).toString());

                        //C电压
                        String modbusDirectiveForCVoltage = properties.getProperty("5");
                        String responseHexForCVoltage = commandServer.invokeModbusDirective(realtimeUUID, BytesHexStrTranslate.toBytes(modbusDirectiveForCVoltage)).
                                getOriginalPackageInfoHex();
                        String responseHexForCVoltageValue = DataTransferUtil.transToModbusResponseValue(responseHexForCVoltage);
                        int CVoltageValue = ByteConvert.bytesToUshort(BytesHexStrTranslate.
                                toBytes(responseHexForCVoltageValue.substring(0, responseHexForCVoltageValue.length() / 2)));
                        eleboxVolEleRecord.setcVoltage(
                                new BigDecimal(String.valueOf(CVoltageValue)).
                                        divide(new BigDecimal("10"), 1, BigDecimal.ROUND_UNNECESSARY).toString());

                        //A电流
                        String modbusDirectiveForAElectric = properties.getProperty("6");
                        String responseHexForAElectric = commandServer.invokeModbusDirective(realtimeUUID, BytesHexStrTranslate.toBytes(modbusDirectiveForAElectric)).
                                getOriginalPackageInfoHex();
                        String responseHexForAElectricValue = DataTransferUtil.transToModbusResponseValue(responseHexForAElectric);
                        int AElectricValue = ByteConvert.bytesToUshort(BytesHexStrTranslate.
                                toBytes(responseHexForAElectricValue.substring(0, responseHexForAElectricValue.length() / 2)));
                        eleboxVolEleRecord.setaElectricity(
                                new BigDecimal(String.valueOf(AElectricValue)).
                                        divide(new BigDecimal("100"), 2, BigDecimal.ROUND_UNNECESSARY).toString());

                        //B电流
                        String modbusDirectiveForBElectric = properties.getProperty("7");
                        String responseHexForBElectric = commandServer.invokeModbusDirective(realtimeUUID, BytesHexStrTranslate.toBytes(modbusDirectiveForBElectric)).
                                getOriginalPackageInfoHex();
                        String responseHexForBElectricValue = DataTransferUtil.transToModbusResponseValue(responseHexForBElectric);
                        int BElectricValue = ByteConvert.bytesToUshort(BytesHexStrTranslate.
                                toBytes(responseHexForBElectricValue.substring(0, responseHexForBElectricValue.length() / 2)));
                        eleboxVolEleRecord.setbElectricity(
                                new BigDecimal(String.valueOf(BElectricValue)).
                                        divide(new BigDecimal("100"), 2, BigDecimal.ROUND_UNNECESSARY).toString());

                        //C电流
                        String modbusDirectiveForCElectric = properties.getProperty("8");
                        String responseHexForCElectric = commandServer.invokeModbusDirective(realtimeUUID, BytesHexStrTranslate.toBytes(modbusDirectiveForCElectric)).
                                getOriginalPackageInfoHex();
                        String responseHexForCElectricValue = DataTransferUtil.transToModbusResponseValue(responseHexForCElectric);
                        int CElectricValue = ByteConvert.bytesToUshort(BytesHexStrTranslate.
                                toBytes(responseHexForCElectricValue.substring(0, responseHexForCElectricValue.length() / 2)));
                        eleboxVolEleRecord.setcElectricity(
                                new BigDecimal(String.valueOf(CElectricValue)).
                                        divide(new BigDecimal("100"), 2, BigDecimal.ROUND_UNNECESSARY).toString());

                        //A有功功率
                        String modbusDirectiveForAActivePower = properties.getProperty("15");
                        String responseHexForAActivePower = commandServer.invokeModbusDirective(realtimeUUID, BytesHexStrTranslate.toBytes(modbusDirectiveForAActivePower)).
                                getOriginalPackageInfoHex();
                        String responseHexForAActivePowerValue = DataTransferUtil.transToModbusResponseValue(responseHexForAActivePower);
                        int aActivePowerValue = ByteConvert.bytesToUshort(BytesHexStrTranslate.
                                toBytes(responseHexForAActivePowerValue.substring(0, responseHexForAActivePowerValue.length() / 2)));
                        eleboxVolEleRecord.setaActivePower(
                                new BigDecimal(String.valueOf(aActivePowerValue)).
                                        divide(new BigDecimal("1000"), 3, BigDecimal.ROUND_UNNECESSARY).toString());

                        //B有功功率
                        String modbusDirectiveForBActivePower = properties.getProperty("16");
                        String responseHexForBActivePower = commandServer.invokeModbusDirective(realtimeUUID, BytesHexStrTranslate.toBytes(modbusDirectiveForBActivePower)).
                                getOriginalPackageInfoHex();
                        String responseHexForBActivePowerValue = DataTransferUtil.transToModbusResponseValue(responseHexForBActivePower);
                        int bActivePowerValue = ByteConvert.bytesToUshort(BytesHexStrTranslate.
                                toBytes(responseHexForBActivePowerValue.substring(0, responseHexForBActivePowerValue.length() / 2)));
                        eleboxVolEleRecord.setbActivePower(
                                new BigDecimal(String.valueOf(bActivePowerValue)).
                                        divide(new BigDecimal("1000"), 3, BigDecimal.ROUND_UNNECESSARY).toString());

                        //C有功功率
                        String modbusDirectiveForCActivePower = properties.getProperty("17");
                        String responseHexForCActivePower = commandServer.invokeModbusDirective(realtimeUUID, BytesHexStrTranslate.toBytes(modbusDirectiveForCActivePower)).
                                getOriginalPackageInfoHex();
                        String responseHexForCActivePowerValue = DataTransferUtil.transToModbusResponseValue(responseHexForCActivePower);
                        int cActivePowerValue = ByteConvert.bytesToUshort(BytesHexStrTranslate.
                                toBytes(responseHexForCActivePowerValue.substring(0, responseHexForCActivePowerValue.length() / 2)));
                        eleboxVolEleRecord.setcActivePower(
                                new BigDecimal(String.valueOf(cActivePowerValue)).
                                        divide(new BigDecimal("1000"), 3, BigDecimal.ROUND_UNNECESSARY).toString());

                        //总有功功率
                        String modbusDirectiveForTotalActivePower = properties.getProperty("1");
                        String responseHexForTotalActivePower = commandServer.invokeModbusDirective(realtimeUUID, BytesHexStrTranslate.toBytes(modbusDirectiveForTotalActivePower)).
                                getOriginalPackageInfoHex();
                        String responseHexForTotalActivePowerValue = DataTransferUtil.transToModbusResponseValue(responseHexForTotalActivePower);
                        int totalActivePowerValue = ByteConvert.bytesToUshort(BytesHexStrTranslate.
                                toBytes(responseHexForTotalActivePowerValue.substring(0, responseHexForTotalActivePowerValue.length() / 2)));
                        eleboxVolEleRecord.setTotalActivePower(String.valueOf(totalActivePowerValue));

                        //当前总有功电能
                        String modbusDirectiveForTotalActiveEnergy = properties.getProperty("9");
                        String responseHexForTotalActiveEnergy = commandServer.invokeModbusDirective(realtimeUUID, BytesHexStrTranslate.toBytes(modbusDirectiveForTotalActiveEnergy)).
                                getOriginalPackageInfoHex();
                        String responseHexForTotalActiveEnergyValue = DataTransferUtil.transToModbusResponseValue(responseHexForTotalActiveEnergy);
                        int totalActiveEnergyValue = ByteConvert.bytesToUshort(BytesHexStrTranslate.
                                toBytes(responseHexForTotalActiveEnergyValue.substring(0, responseHexForTotalActiveEnergyValue.length() / 2)));
                        eleboxVolEleRecord.setTotalActiveEnergy(
                                new BigDecimal(String.valueOf(totalActiveEnergyValue)).
                                        divide(new BigDecimal("100"), 2, BigDecimal.ROUND_UNNECESSARY).toString());

                        eleboxVolEleRecord.setRealtimeDate(new Date());

                        eleboxVolEleRecordMapper.insertSelective(eleboxVolEleRecord);

                    } catch (Exception e) {
                        log.error(e.getMessage());
                        continue;
                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }, 3600, null);
    }
}
