package com.data2.java.show.leetcode;

import java.util.Stack;

/**
 * @author leewow
 * @description
 * @date 2020/9/16 下午9:02
 */
public class ReverseListPrintTest {
    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (head == null){
            return new int[]{};
        }
        Stack<Integer> stack = new Stack();
        ListNode temp = head;
        stack.push(temp.val);

        while((temp = temp.next )!= null){
            stack.push(temp.val);
        }

        int[] res = new int[stack.size()];
        int count = 0;
        while(stack.size()> 0){
            res[count++] = stack.pop();
        }
        // return new int[]{stack};

        return res;
    }

    /**
     * 结构
     */

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
}
