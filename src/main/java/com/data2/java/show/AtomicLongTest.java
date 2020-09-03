package com.data2.java.show;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author leewow
 * @description
 * @date 2020/9/3 上午10:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AtomicLongTest {
    public void test(){
        AtomicLong atomicLong = new AtomicLong();
        log.info("{}",atomicLong.incrementAndGet());
    }
}
