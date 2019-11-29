package cn.clboy.springbootprocess.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author cloudlandboy
 * @Date 2019/11/23 下午9:17
 * @Since 1.0.0
 */

public class TestApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("TestApplicationContextInitializer.initialize");
    }
}