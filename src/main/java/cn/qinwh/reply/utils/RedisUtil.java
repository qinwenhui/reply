package cn.qinwh.reply.utils;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @program: reply
 * @description: redis工具类
 * @author: qinwh
 * @create: 2020-05-08 14:10
 **/
@Component
public class RedisUtil {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    // 维护一个本类的静态变量
    private static RedisUtil redisUtil;

    @PostConstruct
    public void init() {
        redisUtil = this;
        redisUtil.redisTemplate = this.redisTemplate;
    }

    /**
     * 将参数中的字符串值设置为键的值，不设置过期时间
     * @param key
     * @param value 必须要实现 Serializable 接口
     */
    public static void set(String key, String value) {
        redisUtil.redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 将参数中的字符串值设置为键的值，设置过期时间
     * @param key
     * @param value 必须要实现 Serializable 接口
     * @param timeout
     */
    public static void set(String key, Object value, Long timeout) {
        if(value instanceof String){
            redisUtil.redisTemplate.opsForValue().set(key, value.toString(), timeout, TimeUnit.SECONDS);
        }else{
            //序列化
            ObjectMapper mapper=new ObjectMapper();
            try {
                String jsonStr = mapper.writeValueAsString(value);
                redisUtil.redisTemplate.opsForValue().set(key, jsonStr, timeout, TimeUnit.SECONDS);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 获取与指定键相关的值
     * @param key
     * @return
     */
    public static <T> T get(String key, Class<T> t) {
        String jsonStr = redisUtil.redisTemplate.opsForValue().get(key);
        if(jsonStr == null){
            return null;
        }
        Object obj = jsonStr;
        //反序列化
        ObjectMapper mapper=new ObjectMapper();
        try {
            obj = mapper.readValue(jsonStr, t);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        return (T) obj;
    }
    /*
    返回的字符串
     */
    public static String get(String key) {
        return redisUtil.redisTemplate.opsForValue().get(key);
    }
    /**
     * 设置某个键的过期时间
     * @param key 键值
     * @param ttl 过期秒数
     */
    public static boolean expire(String key, Long ttl) {
        return redisUtil.redisTemplate.expire(key, ttl, TimeUnit.SECONDS);
    }

    /**
     * 判断某个键是否存在
     * @param key 键值
     */
    public static boolean hasKey(String key) {
        return redisUtil.redisTemplate.hasKey(key);
    }

    /**
     * 向集合添加元素
     * @param key
     * @param value
     * @return 返回值为设置成功的value数
     */
    public static Long sAdd(String key, String... value) {
        return redisUtil.redisTemplate.opsForSet().add(key, value);
    }

    /**
     * 获取集合中的某个元素
     * @param key
     * @return 返回值为redis中键值为key的value的Set集合
     */
    public static Set<String> sGetMembers(String key) {
        return redisUtil.redisTemplate.opsForSet().members(key);
    }

    /**
     * 将给定分数的指定成员添加到键中存储的排序集合中
     * @param key
     * @param value
     * @param score
     * @return
     */
    public static Boolean zAdd(String key, String value, double score) {
        return redisUtil.redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 返回指定排序集中给定成员的分数
     * @param key
     * @param value
     * @return
     */
    public static Double zScore(String key, String value) {
        return redisUtil.redisTemplate.opsForZSet().score(key, value);
    }

    /**
     * 删除指定的键
     * @param key
     * @return
     */
    public static Boolean delete(String key) {
        return redisUtil.redisTemplate.delete(key);
    }

    /**
     * 删除多个键
     * @param keys
     * @return
     */
    public static Long delete(Collection<String> keys) {
        return redisUtil.redisTemplate.delete(keys);
    }

}
