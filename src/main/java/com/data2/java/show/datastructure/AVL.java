package com.data2.java.show.datastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/10 下午8:49
 * AVL 平衡二叉树 - 本质上是一颗二叉查找树，但是它又具有以下特点：
 *      它是一棵空树或它的左右两个子树的高度差不超过1
 *      左子树、又子树也都是一棵平衡二叉树。
 *
 * 平衡因子 = 左子树的高度 - 右子树的高度
 *
 * AVL树的操作基本和二叉查找树一样，这里我们关注的是两个变化很大的操作：插入和删除！
 * AVL树不仅是一颗二叉查找树，它还有其他的性质。如果我们按照一般的二叉查找树的插入方式可能会破坏AVL树的平衡性。同理，在删除的时候也有可能会破坏树的平衡性，所以我们要做一些特殊的处理，包括：单旋转和双旋转！
 * 单螺旋
 * 双螺旋
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
