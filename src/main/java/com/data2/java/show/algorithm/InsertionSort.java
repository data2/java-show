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
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class InsertionSort {
    @Test
    public void test() {
        for (int k : sort(new int[]{2, 1, 4, 6, 5})) {
            System.out.println(k);
        }

    }

    /**
     * 2 1 4 6 5
     *
     * @param arr
     * @return
     */
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j;
            int temp = arr[i];
            //temp是本趟待插入的数，之前从0~i-1的数全是从左→右有序递增。
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

}
