package com.hang.gmall.controller;

import com.hang.gmall.bean.UserAddress;
import com.hang.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @DubboReference(version = "1.0.0", stub = "com.hang.gmall.service.impl.UserServiceStub")
//    @DubboReference(version = "1.0.0", timeout = 1000)
    UserService userService;

    @HystrixCommand(fallbackMethod = "hello")    //当调用出错时，会使用fallbackMethod中的方法进行容错
    @RequestMapping("/initOrder")
    public List<UserAddress> initOrder(@RequestParam("userId") String userId) {
        List<UserAddress> addressList = userService.getUserAddressList(userId);

        return addressList;
    }

    public List<UserAddress> hello(String userId) {
        ArrayList<UserAddress> userAddresses = new ArrayList<>();
        userAddresses.add(new UserAddress(1, "xxx", "xxx", "xxx", "xxx","xxx"));
        return userAddresses;
    }
}
