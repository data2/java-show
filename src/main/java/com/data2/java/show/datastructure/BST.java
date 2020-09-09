package com.data2.java.show.datastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/9 下午8:51
 *
 * 二叉查找树 BST - Binary Search Tree
 *      若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 *      若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 *      它的左、右子树也分别为二叉排序树。
 *
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
    public void test(){
        TreeNode root = new TreeNode(8);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(10));
        root.getLeft().setRight(new TreeNode(1));

        log.info("前序遍历");
        preTraversal(root);

    }


    public void insert(int key, int value){

    }

    /**
     * 前序遍历
     */
    public void preTraversal(TreeNode treeNode){
        if (treeNode != null){
            log.info("{}",treeNode.getValue());
            preTraversal(treeNode.getLeft());
            preTraversal(treeNode.getRight());
        }
    }

    /**
     * 中序遍历
     */
    public void midTraversal(TreeNode treeNode){
        if (treeNode != null){
            midTraversal(treeNode.getLeft());
            log.info("{}",treeNode.getValue());
            midTraversal(treeNode.getRight());
        }
    }

    /**
     * 后序遍历
     */
    public void postTraversal(TreeNode treeNode){
        if (treeNode != null){
            postTraversal(treeNode.getRight());
            postTraversal(treeNode.getLeft());
            log.info("{}",treeNode.getValue());

        }
    }




}
