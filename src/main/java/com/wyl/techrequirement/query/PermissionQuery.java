package com.wyl.techrequirement.query;

import org.apache.commons.lang.StringUtils;

import com.wyl.techrequirement.domain.Permission;
import com.wyl.techrequirement.domain.Role;

/**
 * 
 * 子类自己的查询条件：用户名，email，部门
 *
 */
public class PermissionQuery extends BaseQuery {

	private String perName;

	public PermissionQuery() {
		super(Permission.class.getName());
	}

	@Override
	protected void addWhere() {
		if (StringUtils.isNotBlank(perName)) {
			addCondition("o.perName like ?", "%" + perName + "%");
		}
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}
}
