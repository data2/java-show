package com.data2.java.show;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author leewow
 * @description
 * @date 2020/9/1 下午7:25
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class CountDownLatchTest {

    @Test
    public void test() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("支付订单准备查询就绪，cost:{}s",3);
                latch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("退款订单准备查询就绪，cost:{}s",2);
                latch.countDown();
            }
        }).start();

        latch.await(60, TimeUnit.SECONDS);
        log.info("对账程序开始");
    }


}
