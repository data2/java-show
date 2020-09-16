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
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TopK {
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
