package com.data2.java.show.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author leewow
 * @description
 * @date 2020/9/12 上午11:18
 *
 * 用两个栈实现一个队列
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TwoStackQueueTest {



    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     *
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    class CQueue {

        Stack<Integer> appendStack ;
        Stack<Integer> deleteStack ;

        public CQueue() {
            appendStack = new Stack();
            deleteStack = new Stack();
        }

        public void appendTail(int value) {
            appendStack.push(value);
        }

        public int deleteHead() {
            if (deleteStack.size() > 0 ){
                return deleteStack.pop();
            }else{
                if(appendStack.size() > 0){
                    while(appendStack.size()>0){
                        deleteStack.push(appendStack.pop());
                    }

                    return deleteStack.pop();
                }else{
                    return -1;
                }

            }
        }
    }

}
