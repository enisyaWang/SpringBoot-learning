package cn.clboy.springbootwar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author cloudlandboy
 * @Date 2019/11/20 下午7:10
 * @Since 1.0.0
 */

@Controller
public class Hello {

    @RequestMapping("/hello")
    public String hi(Model model) {
        model.addAttribute("id", System.currentTimeMillis());
        model.addAttribute("name", "张三");
        model.addAttribute("password", "123456");
        return "/WEB-INF/hello";
    }

    @RequestMapping("/abc")
    public String abc(Model model) {
        model.addAttribute("id", System.currentTimeMillis());
        model.addAttribute("name", "张三");
        model.addAttribute("password", "123456");
        return "abc";
    }
}