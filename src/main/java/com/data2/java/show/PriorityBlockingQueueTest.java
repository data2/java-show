package com.data2.java.show;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author leewow
 * @description
 * @date 2020/9/3 下午10:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PriorityBlockingQueueTest {
    @Test
    public void test(){
        /**
         * JDK 中无界优先级阻塞队列PriorityBlockingQueue内部使用堆算法保证每次出队都是优先级最高的元素
         */
//        PriorityBlockingQueue queue = new PriorityBlockingQueue(10,true);


    }
}
