package com.data2.java.show.designpatterns;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/7 下午4:08
 *
 * 装饰器模式：保持接口，增强性能(装饰)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DecoratorPatternTest {

    @Test
    public void test(){
        SimpleIdea simpleIdea = new SimpleIdea();
        simpleIdea.coding();

        ThemeColorIdea themeColorIdea = new ThemeColorIdea(simpleIdea);
        themeColorIdea.coding();
    }

    interface Idea{
        void coding();
    }

    class SimpleIdea implements Idea{

        @Override
        public void coding() {
            log.info("使用 basic idea coding...");
        }
    }


    class ThemeColorIdea implements Idea {
        Idea idea;
        ThemeColorIdea(Idea idea){
            this.idea = idea;
        }

        @Override
        public void coding() {
            log.info("change themecolor to black");
            idea.coding();
        }
    }
}
