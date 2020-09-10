package com.data2.java.show.datastructure;

/**
 * @author leewow
 * @description
 * @date 2020/9/10 下午10:57
 *
 * 红黑二叉树 - Red Black Tree - 是一种自平衡的二叉查找树
 *
 * 1.节点是红色或黑色。
 * 2.根节点是黑色。
 * 3.每个叶子节点都是黑色的空节点（NIL节点）。
 * 4 每个红色节点的两个子节点都是黑色。(从每个叶子到根的所有路径上不能有两个连续的红色节点)
 * 5.从任一节点到其每个叶子的所有路径都包含相同数目的黑色节点。
 *
 *
 * 这些规则保证了：红黑树从根到叶子结点的最长路径不会超过最短路径的2倍
 *
 * 当插入或删除节点的时候，这些规则可能会打破，需要变色、旋转保持还是红黑树
 *
 * 应用场景：
 *      TreeMap
 *      TreeSet
 *      HashMap (java8)
 *
 */
public class RBT {
}
