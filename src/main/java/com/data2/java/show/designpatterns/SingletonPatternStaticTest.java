package com.data2.java.show.designpatterns;

/**
 * @author leewow
 * @description
 * @date 2020/9/9 下午5:07
 * 单例  - 静态内部类 也是饿汉模式
 */
public class SingletonPatternStaticTest {

    private static class Singleton2{
        private static SingletonPatternStaticTest single = new SingletonPatternStaticTest();
    }

    private SingletonPatternStaticTest(){}

    public SingletonPatternStaticTest getInstance(){
        return Singleton2.single;
    }

}
