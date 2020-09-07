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
 * @date 2020/9/7 下午5:14
 *
 * 组合模式：复合模式描述了一组对象的处理方式与对象的单个实例相同
 *      场景：1、话费套餐包含通话+流量
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CompositePatternTest {

    @Test
    public void test(){
        PhoneTime phoneTime = new PhoneTime();
        InternetGB internetGB = new InternetGB();
        phoneTime.content();

        Composite composite = new Composite();
        composite.add(phoneTime);
        composite.add(internetGB);
        composite.content();

    }

    abstract class Content{
        abstract void content();
    }

    class PhoneTime extends Content{

        @Override
        public void content() {
            log.info("500min 通话");
        }
    }

    class InternetGB extends Content{

        @Override
        public void content() {
            log.info("10G 流量");
        }
    }

    class Composite extends Content{

        List<Content> list = Lists.newArrayList();

        @Override
        void content() {
            for (Content c : list){
                c.content();
            }
        }

        void add(Content content){
            list.add(content);
        }

        void rm(Content content){
            list.remove(content);
        }
    }
}
