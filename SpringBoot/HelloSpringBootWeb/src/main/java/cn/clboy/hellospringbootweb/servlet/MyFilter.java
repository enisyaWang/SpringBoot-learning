package cn.clboy.hellospringbootweb.servlet;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * @Author cloudlandboy
 * @Date 2019/11/19 下午8:53
 * @Since 1.0.0
 */

public class MyFilter extends HttpFilter {
    @Override
    public void init() throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.getWriter().write("Intercept request");
    }
}