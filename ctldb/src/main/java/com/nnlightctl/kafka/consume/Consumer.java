package com.nnlightctl.kafka.consume;

import com.alibaba.fastjson.JSONObject;
import com.nnlight.common.PropertiesUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args) {

        new Consumer().consume();
    }

    public void consume() {
        KafkaConsumer<String, String> consumer = null;
        try {
            Properties props = PropertiesUtil.load("kafka/consumer_config.properties");
            consumer = new KafkaConsumer<>(props);

            //subscribe topics
            consumer.subscribe(Arrays.asList("elebox", "light"));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records){

                    switch (record.topic()) {
                        case "elebox":

                            JSONObject jObj = JSONObject.parseObject(record.value());
                            switch (jObj.getString("type")) {
                                case "test":

                                    long latency = System.currentTimeMillis() - jObj.getLong("t");
                                    System.out.println("topic elebox, test : " + latency);

                                    break;
                                case "marker":

                                    long latencyForMarker = System.currentTimeMillis() - jObj.getLong("t");
                                    System.out.println("topic elebox, marker : " + latencyForMarker);

                                    break;
                                default:
                                    break;
                            }
                            break;
                        case "light":
                            JSONObject jsonObject = JSONObject.parseObject(record.value());
                            System.out.println("--------------------receive topic light msg------------------------");
                            System.out.println(jsonObject.toJSONString());
                            break;
                        default:
                            throw new IllegalStateException("Shouldn't be possible to get message on topic " + record.topic());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(consumer!=null){
                consumer.close();
            }
        }
    }
}
