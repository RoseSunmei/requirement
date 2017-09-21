package com.wyl.techrequirement.service;

import java.util.List;

import com.wyl.techrequirement.domain.Permission;
import com.wyl.techrequirement.domain.Role;

public interface IRoleService extends IBaseService<Role> {

	List<Role> getroleName(Long userId);

}
