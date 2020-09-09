package com.data2.java.show.designpatterns;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/9 下午12:30
 *
 * 简单工厂模式：工厂是用于创建其他对象的对象
 *  当创建一个对象不仅仅是一些分配而且涉及一些逻辑时，将它放在专用工厂中而不是在任何地方重复相同的代码是有意义的。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SimpleFactoryPatternTest {

    @Test
    public void test(){
        Printer printer = Factory.create("11.12.2.1",5655);
        log.info(printer.toString());
    }

    static class Factory{
        public static Printer create(String ip, int port){
            return new Printer(ip,port);
        }
    }

    @Data
    @AllArgsConstructor
    @ToString
    static class Printer{
        String ip;
        int port;
    }
}
