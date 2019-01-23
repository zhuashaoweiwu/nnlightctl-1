package com.nnlightctl.redis.datasource;

import com.nnlightctl.redis.sentinelpool.ShardedJedisSentinelPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.*;

import java.util.Collection;
import java.util.Optional;

@Repository("redisDataSource")
public class RedisDataSourceImpl implements RedisDataSource {

    private static final Logger logger = LoggerFactory.getLogger(RedisDataSourceImpl.class);

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    @Autowired
    private ShardedJedisSentinelPool sentinelPool;

    public ShardedJedis getRedisClient() {
        try {
            ShardedJedis shardedJedis = sentinelPool.getResource();
            return shardedJedis;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public void returnResource(ShardedJedis shardedJedis) {
        Optional<ShardedJedis> optionalJedis = Optional.ofNullable(shardedJedis);
        optionalJedis.ifPresent((optionalJedisValue) -> {
            optionalJedisValue.close();
        });
//        shardedJedisPool.returnResource(shardedJedis);
        sentinelPool.returnResource(shardedJedis);
    }

    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
        Optional<ShardedJedis> optionalJedis = Optional.ofNullable(shardedJedis);
        optionalJedis.ifPresent((optionalJedisValue) -> {
            optionalJedisValue.close();
        });

        if (broken) {
//            sentinelPool.close();
            sentinelPool.returnBrokenResource(shardedJedis);
        } else {
//            shardedJedis.close();
            sentinelPool.returnResource(shardedJedis);
        }
    }
}