package com.nnlightctl.kafka.produce;

import com.nnlight.common.PropertiesUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Properties;

public class Produce {
    private int total = 1000000;

    public static void main(String[] args) {

        new Produce().send();
    }

    public void send(){

        long start = System.currentTimeMillis();
        System.out.println("Kafka Producer send msg start,total msgs:"+total);

        // set up the producer
        Producer<String, String> producer = null;
        try {
            Properties props = PropertiesUtil.load("kafka/producer_config.properties");
            producer = new KafkaProducer<>(props);

            for (int i = 0; i < total; i++){
                producer.send(new ProducerRecord<String, String>("elebox",
                        String.valueOf(i), String.format("{\"type\":\"test\", \"t\":%d, \"k\":%d}", System.currentTimeMillis(), i)));

                // every so often send to a different topic
                if (i % 1000 == 0) {
                    producer.send(new ProducerRecord<String, String>("elebox", String.format("{\"type\":\"marker\", \"t\":%d, \"k\":%d}", System.currentTimeMillis(), i)));
                    producer.send(new ProducerRecord<String, String>("light", String.format("{\"type\":\"marker\", \"t\":%d, \"k\":%d}", System.currentTimeMillis(), i)));

                    producer.flush();
                    System.out.println("Sent msg number " + i);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            producer.close();
        }

        System.out.println("Kafka Producer send msg over,cost time:"+(System.currentTimeMillis()-start)+"ms");
    }
}
