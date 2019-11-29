package cn.clboy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author cloudlandboy
 * @Date 2019/11/13 下午2:58
 * @Since 1.0.0
 * springBootApplication：标注一个主程序类，表示这个是一个Springboot 应用
 */

@SpringBootApplication
public class HelloWorldMainApplication {

    public static void main(String[] args) {
        //启动
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}