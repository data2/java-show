package com.data2.java.show.datastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

/**
 * @author leewow
 * @description
 * @date 2020/9/9 下午8:51
 * <p>
 * 1、二叉查找树 BST - Binary Search Tree
 *      若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 *      若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 *      它的左、右子树也分别为二叉排序树。
 *      没有键值相等的节点
 *
 * 2、操作性能与树的高度
 *
 * 二叉查找树很多操作的性能都跟树的高度相关
 * 一棵极其平衡的二叉树（满二叉树或完全二叉树）的高度大约是 log2n
 *
 * 二叉查找树查找节点所需要的次数不超过树的高度 - 二分查找
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BST {

    /**
     * *                  8
     * *          9              10
     * *              1
     * *
     * *
     */
    @Test
    public void test() {
        Random random = new Random();
        TreeNode root = new TreeNode(25);

        for (int i = 0; i < 20; i++) {
            insert(root, random.nextInt(50));
        }

        midTraversal(root);


        midTraversal(delete(root, 25));


    }


    /**
     * 插入节点
     * @param treeNode
     * @param value
     */
    public void insert(TreeNode treeNode, int value) {
        if (treeNode == null) {
            return;
        }

        if (value < treeNode.getValue()) {
            if (treeNode.getLeft() == null){
                treeNode.setLeft(new TreeNode(value));
            }else{
                insert(treeNode.getLeft(), value);
            }
        } else if (value > treeNode.getValue()) {
            if (treeNode.getRight() == null){
                treeNode.setRight(new TreeNode(value));
            }else {
                insert(treeNode.getRight(), value);
            }
        } else{
            return;
        }
    }


    /**
     * 删除二叉搜索树的节点
     * @param treeNode
     * @param value
     * @return
     */
    public TreeNode delete(TreeNode treeNode, int value){
        if(value < treeNode.getValue()){
            return delete(treeNode.getLeft(),value);
        }else if (value > treeNode.getValue()){
            return delete(treeNode.getRight(),value);
        }else {
            //当前节点没有左子树
            if (treeNode.getLeft() == null){
                return treeNode.getRight();
                //当前节点没有右子树
            }else if (treeNode.getRight() == null){
                return treeNode.getLeft();
            }else{
                //当前节点既有左子树又有右子树
                TreeNode rightMinNode = treeNode.getRight();
                //找到当前节点右子树最左边的叶子结点
                while(rightMinNode.getLeft() != null){
                    rightMinNode = rightMinNode.getLeft();
                }
                //将root的左子树放到root的右子树的最下面的左叶子节点的左子树上
                rightMinNode.setLeft(treeNode.getLeft());
                return rightMinNode;
            }
        }
    }
    /**
     * 前序遍历
     */
    public void preTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            log.info("{}", treeNode.getValue());
            preTraversal(treeNode.getLeft());
            preTraversal(treeNode.getRight());
        }
    }

    /**
     * 中序遍历
     */
    public void midTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            midTraversal(treeNode.getLeft());
            log.info("{}", treeNode.getValue());
            midTraversal(treeNode.getRight());
        }
    }

    /**
     * 后序遍历
     */
    public void postTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            postTraversal(treeNode.getRight());
            postTraversal(treeNode.getLeft());
            log.info("{}", treeNode.getValue());

        }
    }


}
