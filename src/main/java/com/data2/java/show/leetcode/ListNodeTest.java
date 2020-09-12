package com.data2.java.show.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Stack;

/**
 * @author leewow
 * @description
 * @date 2020/9/12 下午3:37
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ListNodeTest {

    @Test
    public void test() {

    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     */
    public int[] reverse(ListNode node){
        Stack<Integer> stack = new Stack();
        ListNode temp;
        stack.push(node.val);
        while((temp = node.next) != null){
            stack.push(temp.val);
        }

        int[] result = new int[stack.size()];
        for(int i = 0 ; i < stack.size(); i++){
            result[i] = stack.pop();
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
