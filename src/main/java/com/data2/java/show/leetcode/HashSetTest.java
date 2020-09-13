package com.data2.java.show.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

/**
 * @author leewow
 * @description
 * @date 2020/9/12 上午11:18
 *
 * set 基本操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HashSetTest {
    @Test
    public void test(){
        HashSet<Integer> set = new HashSet();
        set.add(2);
        set.contains(2);
        set.size();
    }
}
