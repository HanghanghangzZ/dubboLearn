package com.hang.gmall.service;

import com.hang.gmall.bean.UserAddress;

import java.util.List;

public interface UserService {
	
	/**
	 * 按照用户id返回所有的收货地址
	 * @param userId
	 * @return
	 */
	public List<UserAddress> getUserAddressList(String userId);

}
