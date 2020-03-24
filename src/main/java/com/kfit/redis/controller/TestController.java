package com.kfit.redis.controller;

import com.kfit.redis.entity.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @Resource
    RedisTemplate<String,Object> redisTemplate2;

//    @Autowired
//    private StringRedisTemplate redisTemplate;

    @RequestMapping("/redisString")
    public String redisString(){
        //ts.redisService();

                redisTemplate.opsForValue().set("myString","myStringValue");
        String redisValue = redisTemplate.opsForValue().get("myString").toString();
        System.out.println(redisValue);
        return redisValue;
    }

    @RequestMapping("/redisObject")
    public Days redisObject(){
        //ts.redisService();
        Days d = new Days();
        d=new Days();
        d.setDate("123");
        d.setDaysId("456");
        d.setItemNumber(123);
        d.setOpenId("dawda");
        d.setTitle("title");

        redisTemplate2.opsForValue().set("myObject",d);
        System.out.println(redisTemplate2.opsForValue().get("myObject").toString());
        return (Days)redisTemplate2.opsForValue().get("myObject");
    }
}
