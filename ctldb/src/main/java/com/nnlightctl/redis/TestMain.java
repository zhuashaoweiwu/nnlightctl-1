package com.nnlightctl.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        System.out.println("Redis Test End");
        System.exit(0);
    }
}
