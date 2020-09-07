package com.data2.java.show.designpatterns;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/7 下午5:25
 * 建造者模式：将一个复杂对象的构建与其表示分离
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BuilderPatternTest {

    @Test
    public void test() {
        Director director = new Director();
        MacBuilder macBuilder = new MacBuilder("i5", "8G");
        director.makeComputer(macBuilder);
        Computer computer = macBuilder.getComputer();
    }

    class Computer {
        String cpu; // 必选
        String ram; // 必选
        String keybord;
        String usb;
        String screen;

        public Computer(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public void setKeybord(String keybord) {
            this.keybord = keybord;
        }

        public void setUsb(String usb) {
            this.usb = usb;
        }

        public void setScreen(String screen) {
            this.screen = screen;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    abstract class AbstractBuilder {
        public abstract void setKeybord();

        public abstract void setUsb( );

        public abstract void setScreen();

        public abstract Computer getComputer();
    }

    class MacBuilder extends AbstractBuilder {

        private Computer computer;

        MacBuilder(String cpu, String ram) {
            this.computer = new Computer(cpu, ram);
        }

        @Override
        public void setKeybord() {
            computer.setKeybord("mac keybord ");
        }

        @Override
        public void setUsb() {
            computer.setUsb("type c 666");
        }

        @Override
        public void setScreen() {
            computer.setScreen("retina screen");
        }

        @Override
        public Computer getComputer() {
            return computer;
        }
    }


    class Director {
        public void makeComputer(MacBuilder builder) {
            builder.setKeybord();
            builder.setUsb();
            builder.setScreen();
        }
    }
}
