package cn.clboy.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author cloudlandboy
 * @Date 2019/11/13 下午3:05
 * @Since 1.0.0
 * RestController：是spring4里的新注解，是@ResponseBody和@Controller的缩写。
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello SpringBoot,this is my first Application";
    }
}