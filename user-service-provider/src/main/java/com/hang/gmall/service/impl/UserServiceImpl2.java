package com.hang.gmall.service.impl;

import com.hang.gmall.bean.UserAddress;
import com.hang.gmall.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.ArrayList;
import java.util.List;

@DubboService(version = "2.0.0")
public class UserServiceImpl2 implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceImpl2......2...");
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        userAddress.setUserAddress("xxxxxx市");
        ArrayList<UserAddress> userAddresses = new ArrayList<>();
        userAddresses.add(userAddress);
        return userAddresses;
    }
}
