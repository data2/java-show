package com.data2.java.show;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author leewow
 * @description
 * @date 2020/9/3 上午10:16
 * <p>
 * DelayQueue 阻塞队列-延时队列
 * 使用场景：
 * 1、设计一个缓存系统
 * 2、设计一个定时任务
 * <p>
 * DelayQueue这是一个无界的延时阻塞队列.
 * DelayQueue内部是使用优先级队列PriorityQueue实现的,使用时间来做优先级的延时阻塞队列
 * DelayQueue = BlockingQueue + PriorityQueue + Delayed
 */
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class DelayQueueTest {
    @Test
    public void test() throws InterruptedException {
        BlockingQueue<ScheduleJobDelayed> queue = new DelayQueue();
        queue.put(new ScheduleJobDelayed("job1", 2));
        queue.put(new ScheduleJobDelayed("job2", 4));

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    log.info("尝试消费");
                    ScheduleJobDelayed ele = queue.poll();
                    if (ele != null) {
                        log.info("当前消费的job,name:{}", ele.jobName);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(60000);
    }

    private class ScheduleJobDelayed implements Delayed {
        String jobName;
        long delayTime;

        public ScheduleJobDelayed(String job1, long i) {
            jobName = job1;
            delayTime = i;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return delayTime;
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) this.getDelay(TimeUnit.SECONDS) - (int) o.getDelay(TimeUnit.SECONDS);
        }
    }
}
