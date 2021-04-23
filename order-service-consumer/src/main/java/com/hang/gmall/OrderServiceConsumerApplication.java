package com.hang.gmall;

import com.hang.gmall.bean.UserAddress;
import com.hang.gmall.service.impl.OrderServiceImpl;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@EnableDubbo
@EnableHystrix
public class OrderServiceConsumerApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext run = SpringApplication.run(OrderServiceConsumerApplication.class, args);

//        OrderServiceImpl orderService = run.getBean(OrderServiceImpl.class);
//        List<UserAddress> userAddresses = orderService.initOrder("1");
//        System.out.println(userAddresses);
//        System.out.println("调用结束");
//        System.in.read();
    }

}
