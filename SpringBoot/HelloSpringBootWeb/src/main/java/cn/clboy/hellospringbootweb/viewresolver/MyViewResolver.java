package cn.clboy.hellospringbootweb.viewresolver;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @Author cloudlandboy
 * @Date 2019/11/16 上午11:23
 * @Since 1.0.0
 */
@Component
public class MyViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        return null;
    }
}