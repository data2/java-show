package com.data2.java.show;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leewow
 * @description
 * @date 2020/9/3 下午10:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ConcurrentHashMapTest {

    @Test
    public void testMap(){
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("key", "val");
        concurrentHashMap.getOrDefault("key","nb");


    }
}
