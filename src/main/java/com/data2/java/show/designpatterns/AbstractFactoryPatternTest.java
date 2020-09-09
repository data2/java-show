package com.data2.java.show.designpatterns;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/9 下午1:20
 *
 * 抽象工厂模式：
 *      抽象工厂模式与工厂方法模式最大的区别：抽象工厂中每个工厂可以创建多种类的产品；而工厂方法每个工厂只能创建一类
 *
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AbstractFactoryPatternTest {
    @Test
    public void t(){
        IdeaFactory ideaFactory = new IdeaFactory();
        Idea idea = ideaFactory.createDev();
        IdeaJshell ideaJshell = ideaFactory.createTest();

        EclipseFactory eclipseFactory = new EclipseFactory();
        Eclipse eclipse = eclipseFactory.createDev();
        EclipseJshell eclipseJshell = eclipseFactory.createTest();

    }

    abstract class Tool{
        abstract void tool();
    }

    abstract class DevTool extends Tool{
    }

    abstract class TestTool extends Tool{
    }

    // 两层 产品维度
    class Idea extends DevTool {

        @Override
        void tool() {
            log.info("use idea write..");
        }
    }

    class Eclipse extends DevTool {

        @Override
        void tool() {
            log.info("use eclipse write..");
        }
    }

    class IdeaJshell extends TestTool {

        @Override
        void tool() {
            log.info("use ideaJshell test..");
        }
    }

    class EclipseJshell extends TestTool {

        @Override
        void tool() {
            log.info("use eclipseJshell test..");
        }
    }

    // 工厂
    abstract class Factory{
        abstract DevTool createDev();
        abstract TestTool createTest();
    }

    class IdeaFactory extends Factory {

        @Override
        Idea createDev() {
            return new Idea();
        }

        @Override
        IdeaJshell createTest() {
            return new IdeaJshell();
        }
    }

    class EclipseFactory extends Factory {

        @Override
        Eclipse createDev() {
            return new Eclipse();
        }

        @Override
        EclipseJshell createTest() {
            return new EclipseJshell();
        }
    }
}
