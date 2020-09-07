package com.data2.java.show.designpatterns;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/7 上午11:39
 * 策略模式：不同的策略实现统一接口，将策略注入到context对象，context对象根据它的策略改变而改变它的相关行为
 * 策略模式：一个算法接口、多个算法实现、一个Context来包装一下，就完事了
 *      应用场景：
 *          1、java线程池ThreadPoolExecutor的拒绝策略 - RejectedExecutionHandler
 *              直接抛出异常、使用调用者的线程来处理、直接丢掉这个任务、丢掉最老的任务
 *
 *
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StrategyPatterTest {
    @Test
    public void test(){
        Context context = new Context(new AddStrategy());
        context.execute();
        context = new Context(new SubStrategy());
        context.execute();
    }

    class Context{
        Strategy strategy;

        Context(Strategy strategy){
            this.strategy = strategy;
        }

        void execute(){
            strategy.execute();
        }

    }

    interface Strategy{
        public void execute();
    }

    class AddStrategy implements Strategy{

        @Override
        public void  execute(){
            log.info("add");
        }
    }

    class SubStrategy implements Strategy{

        @Override
        public void  execute(){
            log.info("sub");
        }
    }


}
