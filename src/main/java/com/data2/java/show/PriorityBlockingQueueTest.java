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
 *
 * PriorityBlockingQueue - 优先级阻塞队列
 *      最小堆算法,保证每次出队都是优先级最高的元素
 *      队列元素必须实现Comparable接口
 *
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PriorityBlockingQueueTest {
    @Test
    public void test() throws InterruptedException {
        PriorityBlockingQueue<PriorityObject> queue = new PriorityBlockingQueue();
        queue.put(new PriorityObject("obj1", 2));
        queue.put(new PriorityObject("obj2", 1));

        log.info(queue.take().name);
        log.info(queue.take().name);

    }

    private class PriorityObject implements Comparable<PriorityObject>{
        String name ;
        int priority;
        public PriorityObject(String obj2, int i) {
            name = obj2;
            priority = i;
        }

        @Override
        public int compareTo(PriorityObject o) {
            return   o.priority - this.priority;
        }
    }
}
