package cn.clboy.springbootprocess.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author cloudlandboy
 * @Date 2019/11/23 下午9:43
 * @Since 1.0.0
 */

@Component
public class TestCommandLineRunn implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("TestCommandLineRunn.runt\t--->"+ Arrays.toString(args));
    }
}