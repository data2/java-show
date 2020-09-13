package com.data2.java.show.leetcode;

/**
 * @author leewow
 * @description
 * @date 2020/9/13 下午4:22
 *
 * 返回链表中倒数某个节点
 */
public class LastHitListNodeTest {

    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int length = 1;
        ListNode temp = head;
        while((temp = temp.next) != null){
            length ++;
        }

        temp = head;
        for(int i= 2 ; i <= (length - k + 1); i ++){
            temp = temp.next;
        }
        return temp;
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
