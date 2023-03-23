package com.metalearning;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableSwagger2Doc
@EnableFeignClients
@SpringBootApplication
public class MetalearningContentApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetalearningContentApiApplication.class, args);
    }

}
