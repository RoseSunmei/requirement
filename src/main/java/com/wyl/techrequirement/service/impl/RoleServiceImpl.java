package com.wyl.techrequirement.service.impl;

import java.util.List;

import com.wyl.techrequirement.domain.Role;
import com.wyl.techrequirement.service.IRoleService;

public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

	// 通过userId获取角色名字
	@Override
	public List<Role> getroleName(Long userId) {
		String hql = "select r from User u join u.roles r where u.userId = ?";
		return baseDao.findByHql(hql, userId);
	}
}
