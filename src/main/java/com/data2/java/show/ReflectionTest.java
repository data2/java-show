package com.data2.java.show;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;

/**
 * @author leewow
 * @description
 * @date 2020/9/5 下午3:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ReflectionTest {

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Cat cat = new Cat("猫");
        Class cls = cat.getClass();

        log.info("属性：{}", cls.getFields());
        log.info("构造器集合：{}",cls.getConstructors());
        log.info("构造器 - 指定参数：{}",cls.getConstructor(String.class));
        log.info("方法:{}",cls.getMethods());
//        log.info("方法:{} - 指定参数",cls.getMethod("dd", Integer.class));

        log.info("类实现的接口：{}",cls.getInterfaces());
        log.info("类的父类：{}",cls.getSuperclass());
        log.info("类的注解：{}",cls.getAnnotations());

        cls.getMethod("tt", Integer.class).invoke(cat, 2);
        Cat generateCat = (Cat) cls.getConstructor(String.class).newInstance("对象");
        generateCat.tt();


    }
}
