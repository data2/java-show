package com.data2.java.show.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/12 上午11:18
 *
 * 选择排序 O(n*n)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SelectSort {
    @Test
    public void test(){
        for(int k : sort(new int[]{2,1,4,6,5})){
            System.out.println(k);
        }

    }

    /**
     *  2 1 4 6 5
     * @param arr
     * @return
     */
    public int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

}
