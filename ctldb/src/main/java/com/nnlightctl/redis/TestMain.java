package com.nnlightctl.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.ShardedJedisPipeline;

import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:/config/spring-redis.xml");
        RedisClientTemplate redisClient = (RedisClientTemplate)ac.getBean("redisClientTemplate");
        System.out.println(redisClient.set("a", "abc"));
        System.out.println(redisClient.get("b"));
        Map<String, String> hashMap = redisClient.hgetAll("hash-key");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        //string append
        System.out.println(redisClient.get("key"));
        System.out.println(redisClient.append("key", "world"));
        System.out.println(redisClient.get("key"));
        System.out.println("Redis Test End");

        //pipline
        System.out.println("Redis Test pipeline");
        ShardedJedisPipeline pipeline = redisClient.pipeline();
        System.out.println(pipeline.set("pipelineKeyTest", "OK").toString());
        System.out.println(pipeline.set("pipelineKeyTest2", "OK2").toString());
        System.out.println(pipeline.get("pipelineKeyTest").toString());
        System.out.println(pipeline.get("pipelineKeyTest2").toString());
        List<Object> resultList = pipeline.syncAndReturnAll();
        for (Object result : resultList) {
            System.out.println(result.toString());
        }

        System.exit(0);
    }
}
