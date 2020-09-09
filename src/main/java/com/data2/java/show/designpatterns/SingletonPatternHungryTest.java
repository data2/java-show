package com.data2.java.show.designpatterns;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/9 下午4:54
 *
 * 单例模式 - 饿汉模式
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SingletonPatternHungryTest {

    // 静态变量 饿汉模式-类加载初始化
    static SingletonPatternHungryTest singletonPatternHungryTest = new SingletonPatternHungryTest();

    // 私有构造器
    private SingletonPatternHungryTest(){
    }

    // 全局唯一访问点
    public static SingletonPatternHungryTest getInstance(){
        return singletonPatternHungryTest;
    }

    @Test
    public void test(){
        SingletonPatternHungryTest.getInstance().toString();
    }


}
