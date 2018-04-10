package com.cache;

import com.bean.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserCache {
    //存储简单字符串类型
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, Object> valops;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valopsStr;

    //存储字符串
    public void saveStr(String key,String value){
        valopsStr.set(key, value);
    }
    //存储对象User
    public void saveUser(User user){
        valops.set(String.valueOf(user.getId()), user);
    }
    //获取字符串
    public String getString(String key){
        return valopsStr.get(key);
    }
    //获取对象user
    public Object getUser(String userid){
        return  valops.get(userid);
    }


}
