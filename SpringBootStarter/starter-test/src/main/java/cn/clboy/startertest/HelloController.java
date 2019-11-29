package cn.clboy.startertest;

import cn.clboy.spring.boot.autoconfigure.ClboyAutoConfiguration.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cloudlandboy
 * @Date 2019/11/24 上午11:23
 * @Since 1.0.0
 */

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String sayHello() {
        String hello = helloService.sayHello("Peppa Pig");
        return hello;
    }
}