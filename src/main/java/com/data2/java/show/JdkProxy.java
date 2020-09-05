package com.data2.java.show;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author leewow
 * @description
 * @date 2020/9/4 下午9:13
 *
 * jdk动态代理基于java反射机制实现的
 *      获取代理类
 *      获取代理类的构造器 - cls.getConstructor
 *      构造器实例化创建对象 - constructor.newInstance
 *
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JdkProxy {
    @Test
    public void testJdk(){
        Cat cat = new Cat();
        Animals animals = (Animals) JdkProxyFactory.proxy(cat);
        animals.print("fish");
    }

    static class JdkProxyFactory {
        public static Object proxy(Object obj)  {
            return Proxy.newProxyInstance(
                    obj.getClass().getClassLoader(),
                    obj.getClass().getInterfaces(),
                    new TestHandler(obj));
        }
    }

    static class TestHandler  implements InvocationHandler{
        Object object;
        TestHandler(Object object){
            this.object = object;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            log.info("call method:{},params:{}",method.getName(),args);
            Object returnVal = method.invoke(object,args);
            log.info("returnVal:{}", returnVal);
            return returnVal;
        }
    }

    interface Animals{
        String print(String food);
    }

    @NoArgsConstructor
    class Cat implements Animals{

        @Override
        public String print(String food) {
            System.out.println("eat:"+food);
            return food;
        }
    }


}
