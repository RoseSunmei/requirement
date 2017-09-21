package com.wyl.techrequirement.service.impl;

import java.util.List;

import com.wyl.techrequirement.domain.User;
import com.wyl.techrequirement.service.IUserService;

public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
	@Override
	public boolean findByName(String userName) {
		// String hql="select o from Employee o where o.name=?";
		// 性能高一些
		String hql = "select count(o) from User o where o.userName=?";
		List<Long> list = baseDao.findByHql(hql, userName);
		// if(list.size()>0){//错误的写法
		// count无论如果都有返回值:0-n
		if (list.get(0) > 0) {// ("{\"valid\":false}");用户名重复
			return false;
		}
		return true;
	}

	@Override
	public User findByLogin(String userName, String userPwd) {
		String hql = "select o from User o where o.userName=? and o.userPwd=?";
		List<User> list = baseDao.findByHql(hql, userName, userPwd);
		if (list.size() > 0) {// 必须判断size
			return list.get(0);
		}
		return null;
	}
}
