package cn.clboy.hellospringbootweb.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author cloudlandboy
 * @Date 2019/11/16 下午7:41
 * @Since 1.0.0
 */


public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求参数中的语言
        String language = httpServletRequest.getParameter("l");
        //没带区域信息参数就用系统默认的
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)) {
            //提交的参数是zh_CN （语言代码_国家代码）
            String[] s = language.split("_");

            locale = new Locale(s[0], s[1]);

        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}