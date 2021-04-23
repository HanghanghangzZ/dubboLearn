package com.hang.gmall.service.impl;

import com.hang.gmall.bean.UserAddress;
import com.hang.gmall.service.OrderService;
import com.hang.gmall.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class OrderServiceImpl implements OrderService {

    @DubboReference(check = false)
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("用户id：" + userId);

        List<UserAddress> addressList = userService.getUserAddressList(userId);
        for (UserAddress userAddress : addressList) {
            System.out.println(userAddress.getUserAddress());
        }
        return addressList;
    }


}