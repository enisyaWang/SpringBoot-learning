package cn.clboy.hellospringbootweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author cloudlandboy
 * @Date 2019/11/19 下午8:35
 * @Since 1.0.0
 */

public class MyServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("servlet初始化");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("this is MyServlet");
    }

}