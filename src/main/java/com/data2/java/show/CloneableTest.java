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
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CloneableTest {

    @Test
    public void test(){
        Person older = new Person("tom",new Addr("shanghai"));
        Person newer = older.clone();
        newer.setName("trump");
        newer.setAddr(new Addr("beijing"));

        // 如果老人的地址城市改变成beijing，浅拷贝
        log.info(older.toString());

        System.out.println(older.getAddr() == newer.getAddr());
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
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return person;
        }

    }

    @Data
    class Addr {
        String city;
        Addr(String city){
            this.city = city;
        }
    }


}
