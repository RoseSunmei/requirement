package com.wyl.techrequirement.domain;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private Long roleId; // 角色id
	private String roleName;// 角色名字
	// 多对多：当前角色拥有的权限列表
	private Set<Permission> permissions = new HashSet<Permission>();

	public Role() {

	}

	public Role(Long roleId) {
		this.roleId = roleId;
	}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return roleName;
	}
	
}
