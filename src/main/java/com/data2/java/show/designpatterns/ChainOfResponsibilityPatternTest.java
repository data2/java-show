package com.data2.java.show.designpatterns;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/7 上午10:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ChainOfResponsibilityPatternTest {
    @Test
    public void test(){

        Manager manager = new Manager();
        Director director = new Director();
        Ceo ceo = new Ceo();
        manager.setNextHandler(director);
        director.setNextHandler(ceo);

        manager.process();

    }

    // 抽象处理者
    @Data
    abstract class Handler{
        protected Handler nextHandler;
        abstract void process();
    }

    // 具体处理者
    class Manager extends Handler{

        @Override
        void process() {
            boolean ok = false;
            if (!ok){
                nextHandler.process();
                log.info("manager deal fail, throw to leader");
            }
        }
    }

    class Director extends Handler{

        @Override
        void process() {
            boolean ok = false;
            if (!ok){
                nextHandler.process();
                log.info("director deal fail, throw to leader");

            }
        }
    }

    class Ceo extends Handler{

        @Override
        void process() {
            boolean ok = false;
            if (!ok){
                log.info("cep deal fail, end");
            }
        }
    }

}
