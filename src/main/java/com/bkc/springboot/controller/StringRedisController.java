package com.bkc.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringRedisController {
    private static Logger logger = LoggerFactory.getLogger(StringRedisController.class);

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    ValueOperations<String, String> valueOperations;


    @RequestMapping("set")
    public String setKeyValue(String key, String value) {
        logger.info("访问set:key={},value={}", key, value);
        valueOperations.set(key, value);
        return "Set ok";
    }

    @RequestMapping("get")
    public String getKey(String key) {
        logger.info("访问get: key={}", key);
        return valueOperations.get(key);
    }
}
