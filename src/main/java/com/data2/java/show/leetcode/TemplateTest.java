package com.data2.java.show.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leewow
 * @description
 * @date 2020/9/12 上午11:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TemplateTest {
    @Test
    public void test(){
        String[] arr = "addasd".split("a");
        System.out.println(arr.length);

        System.out.println(firstUniqChar("loveleetcode"));
    }

    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<String,Integer> map =  new HashMap();
        for(char c : chars){
            map.put(c+"",map.get(c+"") == null ? 1 :map.get(c+"")+1);
        }

        for(char c : chars){
            if(map.get(c + "") != null && map.get(c+"") == 1) {
                return c;
            }
        }
        return chars[0];
    }
}
