package com.data2.java.show;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;

/**
 * @author leewow
 * @description
 * @date 2020/9/1 下午11:24
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {
    @Test
    public void testThreadPool() throws InterruptedException, ExecutionException {
        // 不建议Executors创建线程池方式！ 明确线程池运行规则，避免资源耗尽。
        // Executors创建的线程池对象允许最大请求的线程数为Integer.MAX_VALUE,有可能导致OOM
        // ExecutorService executorService = Executors.newFixedThreadPool(10);
        // ExecutorService executorService1 = Executors.newCachedThreadPool();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                10,20,60, TimeUnit.SECONDS,
                new ArrayBlockingQueue(10), new ThreadPoolExecutor.DiscardPolicy());

        pool.execute(new Runnable() {
            @Override
            public void run() {
                log.info("切克闹");
            }
        });

        Future future = pool.submit(new Runnable() {
            @Override
            public void run() {
                log.info("submit-runnable");
            }
        });

        Future<String> future1 = pool.submit(new Callable(){
            @Override
            public String call(){
                return "submit-callable";
            }
        });
        log.info(future1.get());

        pool.shutdown();
        log.info("关闭线程池，{}", pool.isShutdown());
        while(true){
            if(pool.isTerminated()){
                log.info("已经关闭线程池，{}", pool.isTerminated());
            }
        }

        
    }

    @Test
    public void testThreadStauts(){
        log.info("{},{},{},{}",Thread.State.NEW, Thread.State.RUNNABLE, Thread.State.BLOCKED,
                Thread.State.TERMINATED);
    }
}
