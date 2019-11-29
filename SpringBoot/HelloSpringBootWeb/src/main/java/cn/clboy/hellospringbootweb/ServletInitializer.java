package cn.clboy.hellospringbootweb;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author cloudlandboy
 * @Date 2019/11/20 下午8:11
 * @Since 1.0.0
 */

public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HelloSpringBootWebApplication.class);
    }

}