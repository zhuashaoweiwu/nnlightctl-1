package com.nnlightctl.kafka.consume;

import com.nnlight.common.ObjectTransferUtil;
import com.nnlight.common.PropertiesUtil;
import com.nnlightctl.kafka.topic.TopicConstant;
import com.nnlightctl.net.CommandData;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Consumer {
    public static void main(String[] args) {
        new Consumer().consume();
    }

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
}
