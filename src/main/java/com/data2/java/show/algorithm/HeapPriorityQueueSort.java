package com.data2.java.show.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author leewow
 * @description
 * @date 2020/9/12 上午11:18
 *
 * 堆 - priorityQueue实现
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HeapPriorityQueueSort {
    @Test
    public void test() {

        int topK = 5;
        int[] arr = new int[]{8, 9, 10, 29, 40, 2, 5, 7};


        // 使用一个最大堆（大顶堆）
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        Queue<Integer> heap = new PriorityQueue<>(topK, (i1, i2) -> Integer.compare(i2, i1));

        for (int e : arr) {
            // 当前数字小于堆顶元素才会入堆
            if (heap.isEmpty() || heap.size() < topK || e < heap.peek()) {
                heap.offer(e);
            }
            if (heap.size() > topK) {
                heap.poll(); // 删除堆顶最大元素
            }
        }

        // 将堆中的元素存入数组
        int[] res = new int[heap.size()];
        int j = 0;
        for (int e : heap) {
            res[j++] = e;
        }


        // 输出排序
        for(int x : res){
            System.out.println(x);
        }
    }

}
