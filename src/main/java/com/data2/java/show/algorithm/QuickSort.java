package com.data2.java.show.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author leewow
 * @description
 * @date 2020/9/12 上午11:18
 *
 * 快速排序
 *
 * 基本思想是：通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 *
 * 快速排序使用分治法策略来把一个序列分为两个子序列，基本步骤为：
 * 1、先从序列中取出一个数作为基准数；
 * 2、分区过程：将把这个数大的数全部放到它的右边，小于或者等于它的数全放到它的左边；
 * 3、递归地对左右子序列进行不走2，直到各区间只有一个数。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class QuickSort {
    @Test
    public void test(){
        
    }

    /**
     * 快速排序（递归）
     *
     * ①. 从数列中挑出一个元素，称为"基准"（pivot）。
     * ②. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * ③. 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param arr   待排序数组
     * @param low   左边界
     * @param high  右边界
     */
    public static void quickSort(int[] arr, int low, int high){
        if(arr.length <= 0) return;
        if(low >= high) return;
        int left = low;
        int right = high;

        //挖坑1：保存基准的值
        int temp = arr[left];
        while (left < right){

            //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
            while(left < right && arr[right] >= temp){
                right--;
            }
            arr[left] = arr[right];

            //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
            while(left < right && arr[left] <= temp){
                left++;
            }
            arr[right] = arr[left];
        }

        //基准值填补到坑3中，准备分治递归快排
        arr[left] = temp;
        System.out.println("Sorting: " + Arrays.toString(arr));
        quickSort(arr, low, left-1);
        quickSort(arr, left+1, high);
    }

}
