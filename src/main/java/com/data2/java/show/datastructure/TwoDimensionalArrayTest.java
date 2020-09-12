package com.data2.java.show.datastructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/12 上午10:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TwoDimensionalArrayTest {

    @Test
    public void test(){
        int[][] arr = new int[][]{
                {1,4,5,10},
                {2,5,6,9}
        };

        log.info("数组宽度：{}",arr[0].length);
        log.info("数组高度：{}",arr.length);

        log.info("开始打印第二行");
        for(int k : arr[1]){
            log.info("{}",k);
        }

        log.info("开始打印第三列");
        for (int i = 0; i < arr.length; i++) {
            log.info("{}",arr[i][2]);
        }
    }
}
