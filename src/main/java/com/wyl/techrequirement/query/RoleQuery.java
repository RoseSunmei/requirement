package com.wyl.techrequirement.query;

import org.apache.commons.lang.StringUtils;

import com.wyl.techrequirement.domain.Role;

/**
 * 
 * 子类自己的查询条件：用户名，email，部门
 *
 */
public class RoleQuery extends BaseQuery {
	
	private String roleName;

	public RoleQuery() {
		super(Role.class.getName());
	}

	@Override
	protected void addWhere() {
		if (StringUtils.isNotBlank(roleName)) {
			addCondition("o.roleName like ?", "%" + roleName + "%");
		}
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
