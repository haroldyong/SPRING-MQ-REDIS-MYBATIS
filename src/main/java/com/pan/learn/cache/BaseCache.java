package com.pan.learn.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.Serializable;

/**
 * Created by panhongwei on 2016/5/17.
 */
@Service
public class BaseCache implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(BaseCache.class);

    @Autowired
    public JedisPool jedisPool;

    public void add(String key,Object object){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String json = object.toString();
            jedis.set(key, json);
        }catch (Exception e){
            if(jedis != null){
                jedisPool.returnBrokenResource(jedis);
            }
            logger.error("add cache error", e);
        }finally{
            if(jedis != null){
                jedisPool.returnResource(jedis);
            }
        }
    }

    public Object get(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = jedis.get(key);
            return str;
        }catch (Exception e){
            if(jedis != null){
                jedisPool.returnBrokenResource(jedis);
            }
            logger.error("get data from cache error", e);
            throw new RuntimeException("get data from cache error", e);
        }finally{
            if(jedis != null){
                jedisPool.returnResource(jedis);
            }
        }
    }
}
