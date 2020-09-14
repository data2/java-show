package com.data2.java.show.algorithm;

import com.sun.tools.javac.util.ArrayUtils;
import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;
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
 * 冒泡排序 O(n*n)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BubbleSort {
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
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j + 1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}
