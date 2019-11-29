package cn.clboy.springbootprocess.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author cloudlandboy
 * @Date 2019/11/23 下午9:42
 * @Since 1.0.0
 */
@Component
public class TestApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("TestApplicationRunner.run\t--->"+args);
    }
}