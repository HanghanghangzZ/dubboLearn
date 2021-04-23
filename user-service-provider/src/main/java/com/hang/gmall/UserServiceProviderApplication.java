package com.hang.gmall;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.boot.*;

import java.io.IOException;

@SpringBootApplication
@EnableDubbo
@EnableHystrix      //整合Hystrix进行服务容错
public class UserServiceProviderApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(UserServiceProviderApplication.class, args);
//        System.in.read();
    }
}
