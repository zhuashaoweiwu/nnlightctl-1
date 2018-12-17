package com.nnlightctl.mymessage.consumer;

import com.nnlight.common.ObjectTransferUtil;
import com.nnlight.common.PropertiesUtil;
import com.nnlightctl.dao.EleboxMapper;
import com.nnlightctl.dao.LightSignalLogMapper;
import com.nnlightctl.dao.LightingVolEleRecordMapper;
import com.nnlightctl.jdbcdao.LightMapNetDao;
import com.nnlightctl.jdbcdao.LightSignalRecordDao;
import com.nnlightctl.jdbcdao.LightingVolEleRecordDao;
import com.nnlightctl.kafka.topic.TopicConstant;
import com.nnlightctl.kafka.util.DataTransferUtil;
import com.nnlightctl.mymessage.MsgQuene;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.po.*;
import com.nnlightctl.util.BytesHexStrTranslate;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class Consumer {
    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private LightingVolEleRecordMapper lightingVolEleRecordMapper;

    @Autowired
    private LightMapNetDao lightMapNetDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private LightSignalLogMapper lightSignalLogMapper;

    @Autowired
    private EleboxMapper eleboxMapper;

    @Autowired
    private MsgQuene msgQuene;

    @Autowired
    private LightingVolEleRecordDao lightingVolEleRecordDao;

    @Autowired
    private LightSignalRecordDao lightSignalRecordDao;

    @PostConstruct
    public void consumer() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                logger.info("-------------------------------Message Consumer starting...--------------------------------------");
                while (true) {
                    try {
                        CommandData lightE0Command = msgQuene.take();

                        //e0
                        if (lightE0Command.getControl() == (byte) 0xe0) {
                            LightingVolEleRecord lightingVolEleRecord = DataTransferUtil.transToLightingVolEleRecord(lightE0Command);
                            lightingVolEleRecord.setGmtCreated(new Date());
                            lightingVolEleRecord.setGmtUpdated(new Date());

                            //与数据库灯具配对
                            Lighting lighting = new Lighting();
                            lighting.setUid(lightingVolEleRecord.getUid());
                            lighting.setRealtimeUid(lightE0Command.getRealtimeUUID());
                            lighting.setLightingImei(lightingVolEleRecord.getLightIMEI());
                            lighting.setLongitude(lightingVolEleRecord.getLongitude());
                            lighting.setLatitude(lightingVolEleRecord.getLatitude());
                            lighting.setFaultTag((byte)0);

                            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                                @Override
                                protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                                    //映射终端与数据库灯具
                                    lightMapNetDao.mapLightingNet(lighting);
                                    //写入灯具终端电流电压信息
                                    lightingVolEleRecordDao.addLightingVolEleRecord(lightingVolEleRecord);
//                                    lightingVolEleRecordMapper.insertSelective(lightingVolEleRecord);
                                    //写入灯具信号日志
                                    LightSignalLog lightSignalLog = DataTransferUtil.transToLightSignalLog(lightingVolEleRecord);
                                    lightSignalLog.setOnlineState((byte)1);
//                                    lightSignalLogMapper.insertSelective(lightSignalLog);
                                    lightSignalRecordDao.addLightSignalRecord(lightSignalLog);
                                }
                            });
                        }

                        //e1
                        if (lightE0Command.getControl() == (byte) 0xe1) {
                            logger.info("---------------------------消费E1透传心跳包----------------------------");
                            byte deviceType = lightE0Command.getAddr()[5];
                            if (deviceType == (byte) 0x03) {
                                String eleboxUUID = new String(lightE0Command.getData());
                                String realtimeUUID = lightE0Command.getRealtimeUUID();

                                EleboxExample eleboxExample = new EleboxExample();
                                eleboxExample.createCriteria().andUidEqualTo(eleboxUUID);
                                Elebox elebox = new Elebox();
                                elebox.setRealtimeUid(realtimeUUID);
                                elebox.setGmtUpdated(new Date());
                                eleboxMapper.updateByExampleSelective(elebox, eleboxExample);
                            }

                            if (deviceType == (byte) 0x04) {
                                String netWorkAddr = BytesHexStrTranslate.bytesToHexFun(lightE0Command.getData());
                                String eleboxRealtimeUUID = lightE0Command.getRealtimeUUID();

                                EleboxExample eleboxExample = new EleboxExample();
                                eleboxExample.createCriteria().andNetworkAddrEqualTo(netWorkAddr);
                                Elebox elebox = new Elebox();
                                elebox.setGmtUpdated(new Date());
                                elebox.setRealtimeUid(eleboxRealtimeUUID);
                                eleboxMapper.updateByExampleSelective(elebox, eleboxExample);
                            }
                        }
                    } catch (InterruptedException ie) {
                        logger.error(ie.getMessage());
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                    }
                }
            }
        });
    }
}
