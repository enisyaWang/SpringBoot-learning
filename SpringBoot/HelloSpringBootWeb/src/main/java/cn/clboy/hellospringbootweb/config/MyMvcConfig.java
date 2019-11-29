package cn.clboy.hellospringbootweb.config;

import cn.clboy.hellospringbootweb.servlet.MyFilter;
import cn.clboy.hellospringbootweb.servlet.MyServlet;
import cn.clboy.hellospringbootweb.servlet.MyServletContextListener;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpFilter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author cloudlandboy
 * @Date 2019/11/16 下午3:32
 * @Since 1.0.0
 */

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Bean
    public ServletListenerRegistrationBean myServletContextListener(){
        return new ServletListenerRegistrationBean(new MyServletContextListener());
    }


    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean register = new FilterRegistrationBean(new MyFilter());
        register.setUrlPatterns(Arrays.asList("/myServlet","/"));
        return register;
    }

    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean register = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        register.setLoadOnStartup(1);
        return register;
    }

    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8088);
            }
        };
    }


    private static final String[] excludePaths = {"/", "/index", "/index.html", "/user/login", "/asserts/**"};


    @Bean
    public DefaultErrorAttributes errorAttributes() {
        return new MyErrorAttributes();
    }

    class MyErrorAttributes extends DefaultErrorAttributes {
        @Override
        public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

            //调用父类的方法获取默认的数据
            Map<String, Object> map = new HashMap<>(super.getErrorAttributes(webRequest, includeStackTrace));

            //从request域从获取到自定义数据
            Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", RequestAttributes.SCOPE_REQUEST);
            map.putAll(ext);
            return map;
        }
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //添加不拦截的路径，SpringBoot已经做好了静态资源映射，所以我们不用管
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .excludePathPatterns(excludePaths);
//    }
}

