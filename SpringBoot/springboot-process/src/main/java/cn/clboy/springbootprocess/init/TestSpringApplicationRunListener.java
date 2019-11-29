package cn.clboy.springbootprocess.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author cloudlandboy
 * @Date 2019/11/23 下午9:22
 * @Since 1.0.0
 */

public class TestSpringApplicationRunListener implements SpringApplicationRunListener {


    public TestSpringApplicationRunListener(SpringApplication application,String[] args) {
    }

    @Override
    public void starting() {
        System.out.println("TestSpringApplicationRunListener.starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("TestSpringApplicationRunListener.environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("TestSpringApplicationRunListener.contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("TestSpringApplicationRunListener.contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("TestSpringApplicationRunListener.started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("TestSpringApplicationRunListener.running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("TestSpringApplicationRunListener.failed");
    }
}