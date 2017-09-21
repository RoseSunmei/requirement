package com.wyl.techrequirement.service.impl;

import java.util.List;

import com.wyl.techrequirement.domain.Permission;
import com.wyl.techrequirement.service.IPermissionService;

public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService {
	
	
	@Override
	public List<Permission> findByLoginUserId(Long loginUserId) {
		String hql = "select distinct m from User u join u.roles r join r.permissions m where u.userId = ?";
		return baseDao.findByHql(hql, loginUserId);
	} 
}
