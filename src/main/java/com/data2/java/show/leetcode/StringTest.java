package com.data2.java.show.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/12 上午11:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StringTest {
    @Test
    public void test(){

        log.info("字符串替换{}", "a b c  d".replaceAll("\\s+","_"));
        log.info("字符串替换{}", "a b c  d".replaceAll("\\s","_"));
    }
}
