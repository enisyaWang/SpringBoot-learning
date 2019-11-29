package cn.clboy.hellospringbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @Author cloudlandboy
 * @Date 2019/11/17 上午11:05
 * @Since 1.0.0
 */

@Controller
public class UserController {

    @PostMapping("/user/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {

            //登录成功，把用户信息方法哦session中，防止表单重复提交，重定向到后台页面
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }
        //登录失败,返回到登录页面
        model.addAttribute("msg", "用户名或密码错误！");
        return "login";
    }
}