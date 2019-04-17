package com.nnlightctl.kafka.consume;

import com.nnlight.common.ObjectTransferUtil;
import com.nnlight.common.PropertiesUtil;
import com.nnlightctl.dao.LightSignalLogMapper;
import com.nnlightctl.dao.LightingVolEleRecordMapper;
import com.nnlightctl.hbasedao.LightRealtimeDao;
import com.nnlightctl.jdbcdao.LightDao;
import com.nnlightctl.jdbcdao.LightMapNetDao;
import com.nnlightctl.kafka.topic.TopicConstant;
import com.nnlightctl.kafka.util.DataTransferUtil;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.po.Lighting;
import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.redis.RedisClientTemplate;
import com.nnlightctl.util.BytesHexStrTranslate;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Consumer {

    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private LightingVolEleRecordMapper lightingVolEleRecordMapper;

    @Autowired
    private LightMapNetDao lightMapNetDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private RedisClientTemplate redisClientTemplate;

    @Autowired
    private LightRealtimeDao lightRealtimeDao;

    @Autowired
    private LightSignalLogMapper lightSignalLogMapper;

    public void consume() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                KafkaConsumer<String, byte[]> consumer = null;
                try {
                    Properties props = PropertiesUtil.load("kafka/consumer_config.properties");
                    consumer = new KafkaConsumer<>(props);

                    //subscribe topics
                    consumer.subscribe(Arrays.asList(TopicConstant.TOPIC_ELEBOX,
                            TopicConstant.TOPIC_LIGHT));

                    while (true) {
                        ConsumerRecords<String, byte[]> records = consumer.poll(Integer.MAX_VALUE);
                        for (ConsumerRecord<String, byte[]> record : records) {
                            try {
                                switch (record.topic()) {
                                    case TopicConstant.TOPIC_ELEBOX:
                                        CommandData eleboxE0Command = (CommandData) ObjectTransferUtil.byteArray2Object(record.value());
                                        break;
                                    case TopicConstant.TOPIC_LIGHT:
                                        CommandData lightE0Command = (CommandData) ObjectTransferUtil.byteArray2Object(record.value());
                                        LightingVolEleRecord lightingVolEleRecord = DataTransferUtil.transToLightingVolEleRecord(lightE0Command);
                                        lightingVolEleRecord.setGmtCreated(new Date());
                                        lightingVolEleRecord.setGmtUpdated(new Date());
                                        //与数据库灯具配对
                                        Lighting lighting = new Lighting();
                                        lighting.setUid(lightingVolEleRecord.getUid());
                                        lighting.setRealtimeUid(lightE0Command.getRealtimeUUID());
                                        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                                            @Override
                                            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                                                //映射终端与数据库灯具
                                                lightMapNetDao.mapLightingNet(lighting);
                                                //写入灯具终端电流电压信息
                                                lightingVolEleRecordMapper.insertSelective(lightingVolEleRecord);
                                                //写入灯具信号日志
                                                lightSignalLogMapper.insertSelective(DataTransferUtil.transToLightSignalLog(lightingVolEleRecord));
                                            }
                                        });

                                        //写入Mysql
//                                        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//                                            @Override
//                                            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                                                lightingVolEleRecordMapper.insertSelective(lightingVolEleRecord);
//                                            }
//                                        });
                                        //同时写入redis
//                                    redisClientTemplate.set(lightingVolEleRecord.getUid().getBytes(),
//                                            ObjectTransferUtil.object2ByteArray(lightingVolEleRecord));
                                        //同时写入Hbase
//                                        lightRealtimeDao.addLightRealtimeRecord(lightingVolEleRecord);
                                        break;
                                    default:
                                        throw new IllegalStateException("Shouldn't be possible to get message on topic " + record.topic());
                                }
                            } catch (Exception e) {
                                log.error(e.getMessage());
                            }
                        }
                    }
                } catch (IOException e) {
                    log.error(e.getMessage());
                } finally {
                    if (consumer != null) {
                        consumer.close();
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        new Consumer().consume();
    }
}
