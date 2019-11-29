package cn.clboy.spring.boot.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author cloudlandboy
 * @Date 2019/11/24 上午10:40
 * @Since 1.0.0
 */

@Configuration
@ConditionalOnWebApplication //web应用才生效
@EnableConfigurationProperties(ClboyProperties.class) //让配置类生效，(注入到容器中)
public class ClboyAutoConfiguration {

    private final ClboyProperties clboyProperties;

    /**
     * 构造器注入clboyProperties
     *
     * @param clboyProperties
     */
    public ClboyAutoConfiguration(ClboyProperties clboyProperties) {
        this.clboyProperties = clboyProperties;
    }

    @Bean
    public HelloService helloService() {
        return new HelloService();
    }

    public class HelloService {

        public String sayHello(String name) {
            return clboyProperties.getPrefix() + name + clboyProperties.getSuffix();
        }
    }
}