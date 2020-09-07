package com.data2.java.show.temp;

import lombok.extern.slf4j.Slf4j;

/**
 * @author leewow
 * @description
 * @date 2020/9/5 下午4:50
 */
@Slf4j
public class Cat {
    public String name;
    public int age;

    public Cat(int age) {
        this.age = age;
    }

    public Cat(String name) {
        this.name = name;
    }

    public void tt() {
        log.info("method tt");
    }

    public void dd(int num) {
        log.info("method dd" + num);
    }
}
