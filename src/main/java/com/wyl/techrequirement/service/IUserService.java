package com.wyl.techrequirement.service;

import com.wyl.techrequirement.domain.User;

public interface IUserService extends IBaseService<User> {
	// <!-- 如果不需要事务service层方法名必须以：get和find开头 -->
	boolean findByName(String userName);

	// 验证登录
	// boolean还是对象User好？后续页面需要用户名，id
	User findByLogin(String userName, String userPwd);
}
