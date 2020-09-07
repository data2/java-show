package com.data2.java.show.designpatterns;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author leewow
 * @description
 * @date 2020/9/7 上午11:29
 *
 * 观察者模式:当一个对象的状态发生改变时， 所有依赖于它的对象都得到通知并被自动更新
 *      使用场景：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ObserverPatternTest {

    @Test
    public void test(){
        House house = new House();
        house.addObserver(new ObserverObject("buyer 1"));
        house.addObserver(new ObserverObject("buyer 2"));
        house.addObserver(new ObserverObject("buyer 3"));
        house.priceChange();
    }

    class House{
        List<ObserverObject> observerObjectList = Lists.newArrayList();

        void addObserver(ObserverObject object){
            observerObjectList.add(object);
        }

        void priceChange(){
            for(ObserverObject observerObject : observerObjectList){
                observerObject.notice();
            }
        }
    }

    class ObserverObject {
        String name;
        ObserverObject(String name){
            this.name = name;
        }
        void notice(){
            log.info("{} get notice", name);
        }
    }
}
