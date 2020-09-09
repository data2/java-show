package com.data2.java.show.designpatterns;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/9 下午12:54
 *
 * 1.1 定义
 * 工厂方法模式，又称工厂模式、多态工厂模式和虚拟构造器模式，通过定义工厂父类负责定义创建对象的公共接口，而子类则负责生成具体的对象。
 *
 * 1.2 主要作用
 * 将类的实例化（具体产品的创建）延迟到工厂类的子类（具体工厂）中完成，即由子类来决定应该实例化（创建）哪一个类。
 *
 * 1.3 解决的问题
 * 工厂一旦需要生产新产品就需要修改工厂类的方法逻辑，违背了“开放 - 关闭原则
 *
 * 即简单工厂模式的缺点
 * 之所以可以解决简单工厂的问题，是因为工厂方法模式把具体产品的创建推迟到工厂类的子类（具体工厂）中，此时工厂类不再负责所有产品的创建，而只是给出具体工厂必须实现的接口，这样工厂方法模式在添加新产品的时候就不修改工厂类逻辑而是添加新的工厂子类，符合开放封闭原则，克服了简单工厂模式中缺点
 *
 * 4. 优点
 * 更符合开-闭原则
 * 新增一种产品时，只需要增加相应的具体产品类和相应的工厂子类即可
 * 简单工厂模式需要修改工厂类的判断逻辑
 *
 * 符合单一职责原则
 * 每个具体工厂类只负责创建对应的产品
 * 简单工厂中的工厂类存在复杂的switch逻辑判断
 *
 * 不使用静态工厂方法，可以形成基于继承的等级结构。
 * 简单工厂模式的工厂类使用静态工厂方法
 *
 * 总结：工厂模式可以说是简单工厂模式的进一步抽象和拓展，在保留了简单工厂的封装优点的同时，让扩展变得简单，让继承变得可行，增加了多态性的体现。
 *
 * 5. 缺点
 * 添加新产品时，除了增加新产品类外，还要提供与之对应的具体工厂类，系统类的个数将成对增加，在一定程度上增加了系统的复杂度；同时，有更多的类需要编译和运行，会给系统带来一些额外的开销；
 * 由于考虑到系统的可扩展性，需要引入抽象层，在客户端代码中均使用抽象层进行定义，增加了系统的抽象性和理解难度，且在实现时可能需要用到DOM、反射等技术，增加了系统的实现难度。
 * 虽然保证了工厂方法内的对修改关闭，但对于使用工厂方法的类，如果要更换另外一种产品，仍然需要修改实例化的具体工厂类；
 * 一个具体工厂只能创建一种具体产品
 * 6. 应用场景
 * 在了解了优缺点后，我总结了工厂方法模式的应用场景：
 *
 * 当一个类不知道它所需要的对象的类时
 * 在工厂方法模式中，客户端不需要知道具体产品类的类名，只需要知道所对应的工厂即可；
 * 当一个类希望通过其子类来指定创建对象时
 * 在工厂方法模式中，对于抽象工厂类只需要提供一个创建产品的接口，而由其子类来确定具体要创建的对象，利用面向对象的多态性和里氏代换原则，在程序运行时，子类对象将覆盖父类对象，从而使得系统更容易扩展。
 * 将创建对象的任务委托给多个工厂子类中的某一个，客户端在使用时可以无须关心是哪一个工厂子类创建产品子类，需要时再动态指定，可将具体工厂类的类名存储在配置文件或数据库中。
 *
 * 链接：https://www.jianshu.com/p/d0c444275827
 *
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FactoryMethodPatternTest {
    @Test
    public void test(){

        IdeaFactory ideaFactory = new IdeaFactory();
        ideaFactory.create().write();

        EclipseFactory eclipseFactory = new EclipseFactory();
        eclipseFactory.create().write();

    }

    abstract class DevTool{
        abstract void write();
    }

    class Idea extends DevTool{

        @Override
        void write() {
            log.info("use idea write..");
        }
    }

    class Eclipse extends DevTool{

        @Override
        void write() {
            log.info("use eclipse write..");
        }
    }

    abstract class Factory{
        abstract DevTool create();
    }

    class IdeaFactory extends Factory{

        @Override
        DevTool create() {
            return new Idea();
        }
    }

    class EclipseFactory extends Factory{

        @Override
        DevTool create() {
            return new Eclipse();
        }
    }
}
