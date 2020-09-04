package com.data2.java.show;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;

/**
 * @author leewow
 * @description
 * @date 2020/9/4 下午5:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CglibAsmEnhancerTest {

    @Test
    public void test(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AtomicLongTest.class);
        enhancer.setClassLoader(getClass().getClassLoader());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                log.info("调用方法:{}, 参数:{}",method.getName(),objects);
                return methodProxy.invokeSuper(o,objects);
            }


        });
        AtomicLongTest test = (AtomicLongTest) enhancer.create();
        test.test();
    }






}
