package com.data2.java.show.datastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/10 下午8:49
 * 1、AVL 平衡二叉树 - 本质上是一颗二叉查找树，但是它又具有以下特点：
 *      它是一棵空树或它的左右两个子树的高度差不超过1
 *      左子树、又子树也都是一棵平衡二叉树。
 *
 * 平衡因子 = 左子树的高度 - 右子树的高度
 *
 * 2、解决的问题
 *      平衡二叉查找树这类数据结构的初衷是，
 *      解决普通二叉查找树在频繁的插入、删除等动态更新的情况下，出现时间复杂度退化的问题（链表）
 *
 * 3、螺旋
 * AVL树的操作基本和二叉查找树一样，这里我们关注的是两个变化很大的操作：插入和删除！
 * 按照一般的二叉查找树的插入方式可能会破坏AVL树的平衡性。同理，在删除的时候也有可能会破坏树的平衡性，所以我们要做一些特殊的处理，包括：单旋转和双旋转！
 *
 * 单螺旋 双螺旋
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AVL {

    public boolean isBalanced(TreeNode treeNode){
        return Math.abs(height(treeNode.getLeft()) - height(treeNode.getRight())) <= 1
                && isBalanced(treeNode.getLeft()) && isBalanced(treeNode.getRight());
    }

    public int height(TreeNode treeNode){
        return Math.max(height(treeNode.getLeft()),height(treeNode.getRight())) + 1;
    }
}
