package cn.clboy.hellospringbootweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cloudlandboy
 * @Date 2019/11/15 下午6:29
 * @Since 1.0.0
 */

@RestController
public class Hello {

    @RequestMapping("/hello")
    public String hello(String str) {
        if ("hi".equals(str)) {
            int i = 10 / 0;
        }
        return "hello world";
    }
}