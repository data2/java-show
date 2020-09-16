package com.data2.java.show.leetcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Stack;

/**
 * @author leewow
 * @description
 * @date 2020/9/13 下午4:28
 * <p>
 *
 * 反转链表
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReverseListNodeTest {
    @Test
    public void test() {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);

        ListNode res = reverseList(a);
        System.out.println(res);
    }

    /**
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }

        Stack<ListNode> stack = new Stack();
        ListNode temp = head;

        stack.push( new ListNode(temp.val));

        while((temp = temp.next) != null){
            stack.push(new ListNode(temp.val));
        }

        ListNode header = stack.pop();
        temp = header;
        while(stack.size() > 0){
            temp.next = stack.pop();
            temp = temp.next;
        }

        return header;

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
