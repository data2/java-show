package com.data2.java.show.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author leewow
 * @description
 * @date 2020/9/12 上午11:18
 *
 * 双向队列Deque 即是队列又是栈
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DequeTest {
    @Test
    public void test(){
        Deque<Integer> deque = new LinkedList();

        // deque 用作双向队列，两头操作
        deque.offerFirst(1);
        deque.offerLast(2);
        deque.pollFirst();
        deque.pollLast();

        // deque用作栈，只从头部操作
        deque.push(3);
        deque.pop();
    }
}
