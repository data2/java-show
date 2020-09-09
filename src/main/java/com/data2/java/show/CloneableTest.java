package com.data2.java.show;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/7 下午10:10
 *
 * 深拷贝、浅拷贝
 *      1、对象实现Cloneable克隆接口
 *      2、对象的引用类型属性也要实现Cloneable接口
 *      3、对象super.clone(),this.子对象.clone()
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CloneableTest {

    @Test
    public void test(){
        Person older = new Person("tom",new Addr("上海"));
        Person newer = older.clone();
        newer.setName("trump");
        newer.getAddr().setCity("北京");

        // 如果老人的地址城市改变成北京，浅拷贝
        log.info(older.toString());


    }

    @Data
    class Person implements Cloneable{
        String name;
        Addr addr;

        Person(String name, Addr addr){
            this.name = name;
            this.addr = addr;
        }

        @Override
        public Person clone(){
            Person person = null;
            try {
                person = (Person) super.clone();
                person.setAddr(this.addr.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return person;
        }

    }

    @Data
    class Addr implements Cloneable{
        String city;
        Addr(String city){
            this.city = city;
        }

        @Override
        public Addr clone(){
            try {
                return (Addr)super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


}
