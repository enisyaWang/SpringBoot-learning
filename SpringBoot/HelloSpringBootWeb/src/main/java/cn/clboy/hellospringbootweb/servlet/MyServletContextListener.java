package cn.clboy.hellospringbootweb.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Author cloudlandboy
 * @Date 2019/11/19 下午9:04
 * @Since 1.0.0
 */

public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("web容器   启动......");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("web容器   销毁......");
    }
}