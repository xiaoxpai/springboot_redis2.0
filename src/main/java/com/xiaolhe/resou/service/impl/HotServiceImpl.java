package com.xiaolhe.resou.service.impl;

import com.xiaolhe.resou.service.HotService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: 陆袆 >_<
 * @email: amixiao@qq.com
 * @createTime: 2020-09-01  16:14
 */
@Service("hotService")
public class HotServiceImpl implements HotService {


    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     *  添加相关热词
     * @param keyword
     */
    @Override
    public void addHotWord(String keyword) {
        // 名为sortedSetName的Sorted Set不用预先创建，不存在会自动创建，存在则向里添加数据
        String hotword="searchHotWord";
        // 如果关键字存在 热度+1
        Double x =1.0;
        redisTemplate.opsForZSet().incrementScore(hotword, keyword, x);
    }


    /**
     *
     * @return
     */
    @Override
    public List<Map<Object, Object>> getAllValue()  {
        List<Map<Object, Object>> list = new ArrayList<>();
        //获取所有键
        Set<String> keys = redisTemplate.keys("searchHotWord");
        for (String key : keys) {

            HashMap<Object, Object> map = new HashMap<>();
//            //zset类型的键值获取
            if(redisTemplate.type(key).code()=="zset"){
                Object value=redisTemplate.opsForZSet().reverseRange(key,0,5);
                map.put("key", key);
                map.put("value", value);
                list.add(map);
            }
            //String类型的键值获取
//            if(redisTemplate.type(key).code()=="string") {
//                Object value = redisTemplate.opsForValue().get(key);
//
//                map.put("key", key);
//                map.put("value", value);
//                list.add(map);
//            }

//            //set类型的键值获取
//            if(redisTemplate.type(key).code()=="set"){
//                Object value=redisTemplate.opsForZSet().range(key,0,-1);
//                map.put("key", key);
//                map.put("value", value);
//                list.add(map);
//            }
//            //list类型的键值获取
//            if(redisTemplate.type(key).code()=="list"){
//                Object value=redisTemplate.opsForZSet().range(key,0,-1);
//                map.put("key", key);
//                map.put("value", value);
//                list.add(map);
//            }
//            //hash类型的键值获取
//            if(redisTemplate.type(key).code()=="hash"){
//                Object value=redisTemplate.opsForZSet().range(key,0,-1);
//                map.put("key", key);
//                map.put("value", value);
//                list.add(map);
//            }

        }
        return list;
    }

}
