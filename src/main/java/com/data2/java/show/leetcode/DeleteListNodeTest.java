package com.data2.java.show.leetcode;

/**
 * @author leewow
 * @description
 * @date 2020/9/13 下午1:28
 * <p>
 * 删除链表中的节点
 */
public class DeleteListNodeTest {

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     *
     * 返回删除后的链表的头节点。
     *
     * 示例 1:
     *
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {

        if (head.val == val){
            return head.next;
        }

        ListNode temp = head.next, tempParent=head;
        while(temp != null){
            if(temp.val == val){
                tempParent.next = temp.next;
                return head;
            }else{
                tempParent.next = temp;
                tempParent = temp;
                temp = temp.next;
            }

        }
        return head;
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
