package cn.clboy.helloworldquickstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cloudlandboy
 * @Date 2019/11/13 下午7:14
 * @Since 1.0.0
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello Spring Boot，this is my first quick start";
    }
}