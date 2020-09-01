package com.data2.java.show;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


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
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable(){
            @Override
            public void run() {
                log.info("对账开始辣");
            }
        });


        new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    log.info("支付订单准备查询开始");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run(){
                try {
                    log.info("退款订单准备查询开始");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }).start();





    }


}
