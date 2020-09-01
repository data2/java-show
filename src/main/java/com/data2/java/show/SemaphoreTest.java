package com.data2.java.show;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;


/**
 * @author leewow
 * @description
 * @date 2020/9/1 下午7:25
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SemaphoreTest {

    @Test
    public void test() throws InterruptedException {
        // 数据库连接数 假设=2
        Semaphore semaphore = new Semaphore(2);
        new Thread(new Runnable(){
            @Override
            public void run(){

                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("支付订单准备开始");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
                log.info("支付订单准备结束");

            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run(){

                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("退款订单准备开始");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphore.release();
                log.info("退款订单准备结束");

            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run(){

                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("充值订单准备开始");
                semaphore.release();
                log.info("充值订单准备结束");

            }
        }).start();


        Thread.sleep(10000);


    }


}
