package com.data2.java.show;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leewow
 * @description
 * @date 2020/9/2 下午3:49
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReentrantLockTest {
    @Test
    public void test() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), new ThreadPoolExecutor.AbortPolicy());

        pool.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    log.info("A尝试获取锁,等待一秒");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (reentrantLock.tryLock()) {
                        log.info("A获取锁成功，执行任务");
                        break;
                    }
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                reentrantLock.unlock();
            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    log.info("B尝试获取锁,等待一秒");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (reentrantLock.tryLock()) {
                        log.info("B获取锁成功，执行任务");
                        break;
                    }
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                reentrantLock.unlock();
            }
        });

        Thread.sleep(20000);
    }


    @Test
    public void condition() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Random random = new Random();

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        Condition produceCondition = reentrantLock.newCondition();
        Condition consumerCondition = reentrantLock.newCondition();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,5,
                30,TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardPolicy());

        // 生产者
        pool.submit(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try{
                        reentrantLock.lock();
                        // not full, put
                        if (queue.size() < 10 ){
                            try {
                                Integer val = Integer.valueOf(random.nextInt(10));
                                queue.put(val);
                                log.info("生产：{}",val );
                                // 生产完 signal 消费者
                                consumerCondition.signalAll();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            produceCondition.await();
                        }
                    }catch (Exception e){
                    }finally {
                        reentrantLock.unlock();
                    }
                }
            }
        });

        // 消费者
        pool.submit(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        reentrantLock.lock();
                        // not empty take
                        if (!queue.isEmpty()){
                            log.info("消费：{}",queue.take());
                            // 消费完 signal 生产者
                            produceCondition.signalAll();
                        }else {
                            consumerCondition.await();
                        }

                    }catch (Exception e){
                    }finally {
                        reentrantLock.unlock();
                    }
                }
            }
        });


        Thread.sleep(30000);

    }
}
