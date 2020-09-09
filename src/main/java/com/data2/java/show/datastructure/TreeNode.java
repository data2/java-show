package com.data2.java.show.datastructure;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leewow
 * @description
 * @date 2020/9/9 下午9:05
 */
@Data
@NoArgsConstructor
public class TreeNode {
    private int key;
    private int value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
