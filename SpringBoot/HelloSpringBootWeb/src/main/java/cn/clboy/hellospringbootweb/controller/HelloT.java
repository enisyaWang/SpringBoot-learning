package cn.clboy.hellospringbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author cloudlandboy
 * @Date 2019/11/15 下午9:32
 * @Since 1.0.0
 */
@Controller
public class HelloT {

    @RequestMapping("/ht")
    public String ht(Model model) {
        model.addAttribute("title","hello Thymeleaf").addAttribute("info","this is first thymeleaf test");
        return "t1";
    }
}