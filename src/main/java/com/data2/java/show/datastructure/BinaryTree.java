package com.data2.java.show.datastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/9 下午9:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BinaryTree {

    /**
     * *                  8
     * *          9              10
     * *              1
     * *
     * *
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(8);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(10));
        root.getLeft().setRight(new TreeNode(1));

        log.info("二叉树的高度：{}", height(root));
        log.info("二叉树的总结点数：{}", nodeSize(root));
        log.info("二叉树的叶子节点数：{}", leafNodeSize(root));

    }


    /**
     * 计算二叉树的高度
     *
     * @param treeNode
     * @return
     */
    public int height(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            int leftHeight = height(treeNode.getLeft());
            int rightHeight = height(treeNode.getRight());
            return leftHeight < rightHeight ? rightHeight + 1 : leftHeight + 1;
        }
    }

    /**
     * 计算总结点数的大小
     *
     * @param treeNode
     * @return
     */
    public int nodeSize(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return 1 + nodeSize(treeNode.getLeft()) + nodeSize(treeNode.getRight());
        }
    }

    /**
     * 计算叶子节点的大小
     *
     * @param treeNode
     * @return
     */
    int total;

    public int leafNodeSize(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            if (treeNode.getLeft() == null && treeNode.getRight() == null) {
                total++;
            }
            leafNodeSize(treeNode.getLeft());
            leafNodeSize(treeNode.getRight());
        }
        return total;
    }


}
