package com.nnlightctl.kafka.produce;

import com.nnlight.common.ObjectTransferUtil;
import com.nnlight.common.PropertiesUtil;
import com.nnlightctl.kafka.topic.TopicConstant;
import com.nnlightctl.net.CommandData;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Properties;

public class Produce {

    private int key = 1;

    public void send(CommandData commandData) {
        send(commandData, TopicConstant.TOPIC_LIGHT);
    }

    public void send(CommandData commandData, String topic) {

        long start = System.currentTimeMillis();

        Producer<String, byte[]> producer = null;
        try {
            Properties props = PropertiesUtil.load("kafka/producer_config.properties");
            producer = new KafkaProducer<>(props);

            producer.send(new ProducerRecord<String, byte[]>(topic, String.valueOf(key++),
                    ObjectTransferUtil.object2ByteArray(commandData)));

            producer.flush();

            if (key > 100000) {
                key = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }

        System.out.println("Kafka Producer send msg over,cost time:" + (System.currentTimeMillis() - start) + "ms");
    }

    public static void main(String[] args) {
        new Produce().send(CommandData.getC8CommandData());
    }
}
