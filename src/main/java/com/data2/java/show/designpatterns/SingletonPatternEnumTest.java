package com.data2.java.show.designpatterns;

import org.junit.Test;

/**
 * @author leewow
 * @description
 * @date 2020/9/9 下午5:10
 *
 * 单例模式 - 枚举实现
 *
 *      枚举类型在jvm中是唯一的，保证枚举在jvm中不能被克隆、序列化
 *      枚举的构造方法默认是私有的
 *      枚举是final修饰的，不可被继承
 */
public class  SingletonPatternEnumTest {

    @Test
    public void test(){
        Singleton singleton = Singleton.INSTANCE;
    }

    enum Singleton{
        INSTANCE
    }
}
