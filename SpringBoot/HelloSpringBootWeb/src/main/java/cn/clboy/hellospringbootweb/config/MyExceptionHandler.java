package cn.clboy.hellospringbootweb.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cloudlandboy
 * @Date 2019/11/19 下午4:15
 * @Since 1.0.0
 */

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap(2);
        map.put("name", "hello");
        map.put("password", "123456");

        //设置状态码
        request.setAttribute("javax.servlet.error.status_code", 500);

        //把数据放到request域中
        request.setAttribute("ext", map);
        return "forward:/error";
    }
}