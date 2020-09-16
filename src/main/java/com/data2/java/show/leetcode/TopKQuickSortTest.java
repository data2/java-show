package com.data2.java.show.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author leewow
 * @description
 * @date 2020/9/16 下午9:38
 *
 * TopK问题 ， eg:最小的k个数
 *
 * Top K 的两种经典解法（堆/快排变形）与优劣比较
 *
 * 解题思路：
 * 这道题是一个经典的 Top K 问题，是面试中的常客。
 * Top K 问题有两种不同的解法，一种解法使用堆（优先队列），另一种解法使用类似快速排序的分治法。
 *
 * 方法一：堆，时间复杂度 O(nlogk)
 * 方法二：快排变形，（平均）时间复杂度 O(n)
 *
 *
 * 方法一：
 *
 * 比较直观的想法是使用堆数据结构来辅助得到最小的 k 个数。堆的性质是每次可以找出最大或最小的元素。
 * 我们可以使用一个大小为 k 的最大堆（大顶堆），将数组中的元素依次入堆，当堆的大小超过 k 时，便将多出的元素从堆顶弹出。
 *
 * 由于每次从堆顶弹出的数都是堆中最大的，最小的 k 个元素一定会留在堆里。这样，把数组中的元素全部入堆之后，堆中剩下的 k 个元素就是最大的 k 个数了。
 *
 * 算法的复杂度分析：
 *
 * 由于使用了一个大小为 k 的堆，空间复杂度为 O(k)；
 * 入堆和出堆操作的时间复杂度均为O(logk)，每个元素都需要进行一次入堆操作，故算法的时间复杂度为O(nlogk)。
 *
 *
 * 方法二：
 *
 * Top K 问题的另一个解法就比较难想到，需要在平时有算法的积累。实际上，“查找第 k 大的元素”是一类算法问题，称为选择问题。
 * 找第 k 大的数，或者找前 k 大的数，有一个经典的 quick select（快速选择）算法。这个名字和 quick sort（快速排序）看起来很像，算法的思想也和快速排序类似，都是分治法的思想。
 *
 *
 *
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TopKQuickSortTest {
    @Test
    public void test(){
        int[] res = getLeastNumbers(new int[]{3,6,2,4,1},3);

    }

    /**
     * 示例 1：
     *
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr,0,arr.length -1);
        int[] res = new int[(k < arr.length? k:arr.length)];
        for(int i= 0;i < res.length; i++){
            res[i] = arr[i];
        }
        return res;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length <= 0 || low >= high) {
            return;
        }
        int left = low;
        int right = high;

        // 保存基准的值
        int temp = arr[left];
        while (left < right) {

            // 1、从右开始！ 顺序不能改变
            while (left < right && arr[right] >= temp) {
                right--;
            }
            // 2、从左开始
            while (left < right && arr[left] <= temp) {
                left++;
            }

            // 交换left(比基准大)、right(比基准小)
            int t = arr[right];
            arr[right] = arr[left];
            arr[left] = t;

        }


        // 当left和right相遇之时， 交换第一个和相遇时位置，把基准之放在中间
        arr[low] = arr[left];
        arr[left] = temp;

        System.out.println("Sorting: " + Arrays.toString(arr));

        // 递归
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }

}
