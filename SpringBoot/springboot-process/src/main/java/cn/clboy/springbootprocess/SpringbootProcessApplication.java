package cn.clboy.springbootprocess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

@SpringBootApplication
public class SpringbootProcessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProcessApplication.class, args);
    }


}
