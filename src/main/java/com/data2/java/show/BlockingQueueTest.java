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
