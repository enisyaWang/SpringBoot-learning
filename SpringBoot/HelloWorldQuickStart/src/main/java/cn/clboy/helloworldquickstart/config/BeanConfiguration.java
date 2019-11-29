package cn.clboy.helloworldquickstart.config;

import cn.clboy.helloworldquickstart.model.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author cloudlandboy
 * @Date 2019/11/14 下午4:33
 * @Since 1.0.0
 *
 * Configuration：指明当前类是一个配置类；就是来替代之前的Spring配置文件
 */


@Configuration
public class BeanConfiguration {

    /**
     *相当于在配置文件中用<bean><bean/>标签添加组件
     */
    @Bean
    public Pet duDu() {
        Pet pet = new Pet();
        pet.setName("嘟嘟");
        pet.setAge(3);
        return pet;
    }
}