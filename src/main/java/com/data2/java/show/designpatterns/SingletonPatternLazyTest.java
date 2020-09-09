package com.data2.java.show.designpatterns;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/9 下午5:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SingletonPatternLazyTest {

    static SingletonPatternLazyTest single;

    private SingletonPatternLazyTest(){}

    public static SingletonPatternLazyTest getInstance(){
        if (single == null){
            synchronized (SingletonPatternLazyTest.class){
                if (single == null){
                    single = new SingletonPatternLazyTest();
                }
            }
        }
        return single;
    }

}
