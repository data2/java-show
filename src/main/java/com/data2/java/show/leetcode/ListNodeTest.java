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
        ListNode first = new ListNode(2);
        first.next =  new ListNode(5);
        first.next.next = new ListNode(9);


        for (int k: reverse(first)){
            System.out.println(k);
        }

        for (int k: reverse2(first)){
            System.out.println(k);
        }



    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * 解题思路：
     *      1、辅助栈 - reverse
     *      2、递归 - reverse2
     */
    public int[] reverse(ListNode node){
        Stack<Integer> stack = new Stack();
        ListNode temp = node;
        stack.push(temp.val);
        while((temp = temp.next) != null){
            stack.push(temp.val);
        }

        int[] result = new int[stack.size()];
        for(int i = 0 ; i < result.length; i++){
            result[i] = stack.pop();
        }
        return result;
    }


    /**
     * 2、递归 - reverse2
     * @param node
     * @return
     */
    public int[] reverse2(ListNode node){
        if (node == null){
            return null;
        }
        ListNode temp = node;
        int size = 1;
        while ((temp = temp.next) != null){
            size++;
        }

        int[] result = new int[size];

        return recursion(node, result, size-1);
    }

    private int[] recursion(ListNode node, int[] result, int index) {
        if (index >= 0){
            result[index] = node.val;
            return recursion(node.next, result, index-1);
        }
        return result;
    }


    /**
     * 结构
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
