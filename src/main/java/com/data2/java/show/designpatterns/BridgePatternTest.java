package com.data2.java.show.designpatterns;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/7 下午4:27
 * 桥接模式：如果一个系统需要在抽象化和具体化之间增加更多的灵活性，避免在两个层次之间建立静态的继承关系，通过桥接模式可以使它们在抽象层建立一个关联关系。
 * 一个类存在两个（或多个）独立变化的维度，且这两个（或多个）维度都需要独立进行扩展。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BridgePatternTest {

    @Test
    public void test(){
        Benz benz = new Benz();
        benz.setOperation(new Auto());
        benz.run();
    }

    abstract class Car{
        Operation operation;

        public void setOperation(Operation operation) {
            this.operation = operation;
        }

        abstract void run();
    }

    class BMW extends Car{

        @Override
        void run() {
            operation.operate();
            log.info("宝马running...");
        }
    }

    class Benz extends Car{

        @Override
        void run() {
            operation.operate();
            log.info("奔驰running...");
        }
    }


    interface Operation{
        void operate();
    }

    class Auto implements Operation{

        @Override
        public void operate() {
            log.info("自动挡");
        }
    }

    class Manu implements Operation{

        @Override
        public void operate() {
            log.info("手动挡");
        }
    }
}
