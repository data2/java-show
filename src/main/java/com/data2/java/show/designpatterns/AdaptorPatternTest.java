package com.data2.java.show.designpatterns;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/7 下午3:23
 * 适配器模式： 将一个类的接口转换成客户期望的另一个接口，适配器让原本接口不兼容的类可以相互合作
 *      在不需要修改老接口的情况下，通过新增适配器，让老接口拥有新接口的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AdaptorPatternTest {
    
    @Test
    public void test(){
        // mac无法安装office，通过虚拟机(适配器)安装了office
        MacAdaptor adaptor = new MacAdaptor(new Office());
        adaptor.setupMac();
    }


    class MacAdaptor implements Mac{
        private Win win;
        MacAdaptor(Win win){
            this.win = win;
        }

        @Override
        public void setupMac() {
            win.setupWin();
        }
    }

    interface Win{
        void setupWin();
    }

    class Office implements Win{

        @Override
        public void setupWin() {
            log.info("windows 安装 office");
        }
    }


    interface Mac{
        void setupMac();
    }

    class Idea implements Mac{

        @Override
        public void setupMac() {
            log.info("mac 安装 idea");
        }
    }

    class Sublime implements Mac{

        @Override
        public void setupMac() {
            log.info("mac 安装 sublime");
        }
    }




}
