package com.data2.java.show;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author leewow
 * @description
 * @date 2020/9/3 上午10:16
 *
 * 生产者消费者实现方式 - not full put; not empty take
 *      1、Synchronize & 对象的wait\notify方法
 *      2、ReentrantLock condition
 *      3、阻塞队列BlockingQueue
 *
 * 阻塞队列分类：
 *      1、ArrayBlockingQueue - 数组实现的有界队列
 *      2、PriorityBlockingQueue - 优先级阻塞队列
 *      3、DelayQueue - 延时队列
 *          场景1：缓存系统
 *          场景2：定时任务
 *          场景3：实现订单超时关闭
 *
 * 入队方法
 *      put:队列满则阻塞
 *      offer:队列满则插入失败，返回false
 *      add:队列满则抛出异常，IllegalStateException
 * 出队方法
 *      take:队列空则阻塞，移除并返回队列头部元素
 *      poll:队列空则返回null，移除并返回队列头部元素
 *      remove: 队列空则抛出异常NoSuchElementException，移除并返回队列头部元素
 *
 *      peek：队列空则返回null，返回队列头部元素
 *      element:队列空抛出异常NoSuchElementException，返回队列头部元素
 *
 */
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class BlockingQueueTest {

    @Test
    public void produceConsumer() throws InterruptedException {
        Random random = new Random();
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(10);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), new ThreadPoolExecutor.AbortPolicy());

        // produce: not full put
        pool.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (queue.size() < 10) {
                            Integer val = Integer.valueOf(random.nextInt(10));
                            log.info("生产者生产:{}", val);
                            queue.put(val);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // consumer: not empty take
        pool.submit(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        if (!queue.isEmpty()){
                            log.info("消费者生产:{}", queue.take());
                            Thread.sleep(2000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread.sleep(20000);

    }

}
