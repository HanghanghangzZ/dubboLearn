package com.hang.gmall.service.impl;

import com.hang.gmall.bean.UserAddress;
import com.hang.gmall.service.UserService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.List;

@DubboService(timeout = 50000, version = "1.0.0", retries = 5)       //将服务注册到注册中心
public class UserServiceImpl implements UserService {

    @HystrixCommand     //将这个方法交给Hystrix代理
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceImpl1......1...");
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        userAddress.setUserAddress("xxxxxx市");
        ArrayList<UserAddress> userAddresses = new ArrayList<>();
        userAddresses.add(userAddress);

//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        /* 模拟远程调用出错，实验Hystrix容错 */
        if (Math.random() > 0.5) {
            throw new RuntimeException();
        }
        return userAddresses;
    }
}
