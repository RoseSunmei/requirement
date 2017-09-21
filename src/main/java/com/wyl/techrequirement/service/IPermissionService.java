package com.wyl.techrequirement.service;

import java.util.List;

import com.wyl.techrequirement.domain.Permission;
import com.wyl.techrequirement.domain.User;

public interface IPermissionService extends IBaseService<Permission> {
	// <!-- 如果不需要事务service层方法名必须以：get和find开头 -->
	
	List<Permission> findByLoginUserId(Long loginUserId);
}
