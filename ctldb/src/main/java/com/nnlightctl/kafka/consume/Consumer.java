package com.nnlightctl.kafka.consume;

import com.nnlight.common.ObjectTransferUtil;
import com.nnlight.common.PropertiesUtil;
import com.nnlightctl.dao.LightingVolEleRecordMapper;
import com.nnlightctl.kafka.topic.TopicConstant;
import com.nnlightctl.kafka.util.DataTransferUtil;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.redis.RedisClientTemplate;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Consumer {
    @Autowired
    private LightingVolEleRecordMapper lightingVolEleRecordMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private RedisClientTemplate redisClientTemplate;

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
                        ConsumerRecords<String, byte[]> records = consumer.poll(300);
                        for (ConsumerRecord<String, byte[]> record : records) {

                            switch (record.topic()) {
                                case TopicConstant.TOPIC_ELEBOX:
                                    CommandData eleboxE0Command = (CommandData) ObjectTransferUtil.byteArray2Object(record.value());
                                    break;
                                case TopicConstant.TOPIC_LIGHT:
                                    CommandData lightE0Command = (CommandData) ObjectTransferUtil.byteArray2Object(record.value());
                                    LightingVolEleRecord lightingVolEleRecord = DataTransferUtil.transToLightingVolEleRecord(lightE0Command);
                                    lightingVolEleRecord.setGmtCreated(new Date());
                                    lightingVolEleRecord.setGmtUpdated(new Date());
                                    //写入Mysql
//                                    transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//                                        @Override
//                                        protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                                            lightingVolEleRecordMapper.insertSelective(lightingVolEleRecord);
//                                        }
//                                    });
                                    //同时写入redis
                                    redisClientTemplate.set(lightingVolEleRecord.getUid().getBytes(),
                                            ObjectTransferUtil.object2ByteArray(lightingVolEleRecord));
                                    //同时写入Hbase
                                    //todo
                                    break;
                                default:
                                    throw new IllegalStateException("Shouldn't be possible to get message on topic " + record.topic());
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
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
